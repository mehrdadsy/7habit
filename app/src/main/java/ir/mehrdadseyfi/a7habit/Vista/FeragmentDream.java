package ir.mehrdadseyfi.a7habit.Vista;

/**
 * Created by admin on 8/26/2017.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.EmergencyNOEssntialShowEditActivity;
import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.NOEsstianlEmergencyActivity;
import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.NOEsstianlEmergencylItem;
import ir.mehrdadseyfi.a7habit.R;

public class FeragmentDream extends Fragment {
    ListView mylist;
    FDlistAdapter adapter;
    private static FeragmentDream feragmentDream;
    int postionAlert;
    List<FDdatabase> models;
    View view;

    public static FeragmentDream newInstance() {

        if (null == feragmentDream)

            feragmentDream = new FeragmentDream();

        return feragmentDream;

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


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_dream, container, false);
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
                Intent intent = new Intent(getActivity(), EdirDreamActivity.class);
                intent.putExtra("id", models.get(position).getId());
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
        alertDialog.setMessage("آیا از حذف کار خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        FDdatabase books = FDdatabase.findById(FDdatabase.class, models.get(postionAlert).getId());
                        books.delete();
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
        models = FDdatabase.listAll(FDdatabase.class);
        adapter = new FDlistAdapter(models, getActivity());
        mylist = (ListView) view.findViewById(R.id.mylist_d);
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