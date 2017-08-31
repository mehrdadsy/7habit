package ir.mehrdadseyfi.a7habit.Calender;

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

import ir.mehrdadseyfi.a7habit.R;

public class ShowDayJobActivity extends AppCompatActivity {
    Context mContext = this;
    List<JobDB> models;
    int postionAlert;
    String year;
    String month;
    String day;
    ListView mylist;
    ShowJobDayListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_day_job);
        Intent intent = getIntent();
        year = intent.getStringExtra("year");
        month = intent.getStringExtra("month");
        day = intent.getStringExtra("day");

        add();
        mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                postionAlert = position;
                AlertPopup();

                return true;
            }
        });

    }

    public void AlertPopup() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();

//tiltle
        alertDialog.setTitle("هشدار");

//maten dialog
        alertDialog.setMessage("آیا از حذف کار خود مطمئن هستید؟");

//dokme ---mitoni ino hey copy koni va  BUTTON_NEUTRAL ino avaz koni dokme jadid biari va ye cari behesh nesbat bedi
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",

                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String del = "DELETE FROM job_DB WHERE name =" + " '" + models.get(postionAlert).getName() + "' and  goal = '" + models.get(postionAlert).getGoal() + "'";
                        JobDB.executeQuery(del);
                        Toast.makeText(ShowDayJobActivity.this, "حذف کار انجام شد", Toast.LENGTH_SHORT).show();
                        add();

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
    public void add(){
        models = JobDB.find(JobDB.class, "year= ? and mount= ? and day= ?", year, month, day);
        mylist  = (ListView) findViewById(R.id.mylist_sd);
        adapter = new ShowJobDayListAdapter(models, mContext);
        mylist.setAdapter(adapter);
        if(models.size()==0){
            finish();
        }
    }

    @Override
    protected void onResume() {
        add();
        super.onResume();
    }


    @Override
    protected void onStart() {
        add();
        super.onStart();
    }
}

