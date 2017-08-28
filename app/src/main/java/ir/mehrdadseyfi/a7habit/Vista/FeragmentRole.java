package ir.mehrdadseyfi.a7habit.Vista;

/**
 * Created by admin on 8/26/2017.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class FeragmentRole extends Fragment {
    ListView mylist;
    FRlistAdapter adapter;
    int postionAlert;
    List<FRdatabase> models;
    View view;
    private static FeragmentRole feragmentRole;


    public static FeragmentRole newInstance() {

        if (null == feragmentRole)

            feragmentRole = new FeragmentRole();

        return feragmentRole;

    }
    @Override
    public void onStart() {
        creatList();
        super.onStart();
    }

    @Override
    public void onResume() {
        creatList();
        super.onResume();
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_role, container, false);

        creatList();
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;

                AlertPopup();
                return true;
            }
        });
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ShowGoalRoleActivity.class);
                intent.putExtra("role",models.get(position).getName());
                intent.putExtra("id",models.get(position).getId());
                startActivity(intent);
            }
        });

        return view;

    }

    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف کار خود مطمئن هستید؟"+"\n"+"دقت کنید که هدف های مربوط به این نقش نیز پاک می شود");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        FRdatabase books = FRdatabase.findById(FRdatabase.class, models.get(postionAlert).getId());
                        books.delete();
                        String name=models.get(postionAlert).getName();
                        List<FGdatabase> notes = FGdatabase.find(FGdatabase.class, "role = ?" , name);

                        for (int i = 0; i < notes.size(); i++) {
                            notes.get(i).getId();
                            FGdatabase books1 = FGdatabase.findById(FGdatabase.class, notes.get(i).getId());
                            books1.delete();
                        }
                        Toast.makeText(getActivity(), "حذف کار انجام شد", Toast.LENGTH_SHORT).show();
                        creatList();


                    }

                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }

                });


        alertDialog.show();


    }
    public void creatList(){
        models = FRdatabase.listAll(FRdatabase.class);
        adapter = new FRlistAdapter(models, getActivity());
        mylist = (ListView) view.findViewById(R.id.mylist);
        mylist.setAdapter(adapter);
        BackGroundIf();

    }
    public void BackGroundIf() {
        ImageView imgBackGround = (ImageView)view.findViewById(R.id.img);
        int i=models.size();
        if (i == 0) {
            imgBackGround.setImageResource(R.drawable.noting);

        } else {

            imgBackGround.setImageDrawable(null);
        }
    }

}