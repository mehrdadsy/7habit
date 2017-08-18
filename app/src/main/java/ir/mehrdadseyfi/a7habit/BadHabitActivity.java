package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class BadHabitActivity extends AppCompatActivity {
    List<BadHabitDB> models;
    Context mContext = this;
    ListView mylist;
    int postionAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_habit);
        AddItemBadHabit();
        mylist = (ListView) findViewById(R.id.mylist_habit);
        findViewById(R.id.add_bad_habit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BadHabitActivity.this, DialogBadHabitAddActivity.class));
            }
        });
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;
                alertPopup();


                return true;
            }
        });
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BadHabitActivity.this, DialogBadHabitShowActivity.class);
                intent.putExtra("id",models.get(position).getId());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        AddItemBadHabit();
        super.onResume();
    }

    @Override
    protected void onStart() {
        AddItemBadHabit();
        super.onStart();
    }


    public void AddItemBadHabit() {
        models = BadHabitDB.listAll(BadHabitDB.class);
        BadHabitAdapter adpter = new BadHabitAdapter(models, mContext);
        try {
            mylist.setAdapter(adpter);

        } catch (Exception e) {

        }
    }

    public void alertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف عادت خود مطمن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        BadHabitDB badHabit = BadHabitDB.findById(BadHabitDB.class, models.get(postionAlert).getId());
                        badHabit.delete();
                        Toast.makeText(BadHabitActivity.this, "حذف عادت انجام شد", Toast.LENGTH_SHORT).show();
                        AddItemBadHabit();

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
}
