package ir.mehrdadseyfi.a7habit.Vista;

/**
 * Created by admin on 8/26/2017.
 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/26/2017.
 */

        public class FeragmentGoal extends Fragment {
    ListView mylist;
    FGlistAdapter adapter;
    int postionAlert;
    List<FGdatabase> models;
    View view;
    private static FeragmentGoal feragmentGoal;

    public static FeragmentGoal newInstance() {

        if (null == feragmentGoal)

            feragmentGoal = new FeragmentGoal();

        return feragmentGoal;

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

         view = inflater.inflate(R.layout.fragment_goal, container, false);

        creatList();
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;
                AlertPopup();
                return true;
            }
        });

        return view;

    }

    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف هدف خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        FGdatabase books = FGdatabase.findById(FGdatabase.class, models.get(postionAlert).getId());
                        books.delete();
                        Toast.makeText(getActivity(), "حذف هدف انجام شد", Toast.LENGTH_SHORT).show();
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
        models = FGdatabase.listAll(FGdatabase.class);
        adapter = new FGlistAdapter(models, getActivity());
        mylist = (ListView) view.findViewById(R.id.mylist_goal);
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