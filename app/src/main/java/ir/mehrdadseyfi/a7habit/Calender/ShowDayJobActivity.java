package ir.mehrdadseyfi.a7habit.Calender;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;

public class ShowDayJobActivity extends AppCompatActivity {
    Context mContext=this;
    List<JobDB> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_day_job);
        Intent intent = getIntent();
        String year = intent.getStringExtra("year");
        String month = intent.getStringExtra("month");
        String day = intent.getStringExtra("day");
models=JobDB.find(JobDB.class,"year= ? and mount= ? and day= ?",year,month,day);
            ListView mylist = (ListView) findViewById(R.id.mylist_sd);
            ShowJobDayListAdapter adapter = new ShowJobDayListAdapter(models, mContext);
            mylist.setAdapter(adapter);

        }

    }

