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

public class LongGoalActivity extends AppCompatActivity {


    ListView mylist;
    int postionAlert;

   Context mContext=this;
    List<GoalSugarDB> books;

    @Override
    protected void onResume() {
        sugarAddITEM();
        super.onResume();
    }

    @Override
    protected void onStart() {
        sugarAddITEM();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_goal);

        sugarAddITEM();
        mylist = (ListView) findViewById(R.id.list_long_goal);
        findViewById(R.id.add_long_goal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LongGoalActivity.this, Dialog.class));
            }
        });

        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        postionAlert=position;
                AlertPopup();

                return true;
            }
        });


    }

    public void sugarAddITEM() {

        books = GoalSugarDB.listAll(GoalSugarDB.class);
        LongGoalSugarAdapter adapterSugar = new LongGoalSugarAdapter(books, this);
        try {
            mylist.setAdapter(adapterSugar);

        } catch (Exception e) {

        }
    }
    public void AlertPopup()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف هدف خود مطمن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        GoalSugarDB book = GoalSugarDB.findById(GoalSugarDB.class, books.get(postionAlert).getId());
                        book.delete();
                        Toast.makeText(LongGoalActivity.this, "حذف هدف انجام شد", Toast.LENGTH_SHORT).show();
                        sugarAddITEM();

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






