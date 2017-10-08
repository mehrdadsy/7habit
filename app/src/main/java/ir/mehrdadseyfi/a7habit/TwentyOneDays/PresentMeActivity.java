package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays.Days3Adapter;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays.Days3DB;

public class PresentMeActivity extends AppCompatActivity {
    TextView days1;
    TextView days2;
    TextView days5;
    TextView days6;
    TextView days7;
    TextView days8;
    TextView days9;
    TextView days10;
    TextView days11;
    TextView days12;
    TextView days13;
    TextView days14;
    TextView days15;
    TextView days16;
    TextView days17;
    Days3DB days3DB;
    ListView mylist;
    Days3Adapter adapter;
    List<Days3DB> models;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_me);
        days1 = (TextView) findViewById(R.id.days1);
        days2 = (TextView) findViewById(R.id.days2);
        days5 = (TextView) findViewById(R.id.days5);
        days6 = (TextView) findViewById(R.id.days6);
        days7 = (TextView) findViewById(R.id.days7);
        days8 = (TextView) findViewById(R.id.days8);
        days9 = (TextView) findViewById(R.id.days9);
        days10 = (TextView) findViewById(R.id.days10);
        days11 = (TextView) findViewById(R.id.days11);
        days12 = (TextView) findViewById(R.id.days12);
        days13 = (TextView) findViewById(R.id.days13);
//        days14 = (TextView) findViewById(R.id.days14);
//        days15 = (TextView) findViewById(R.id.days15);
//        days16 = (TextView) findViewById(R.id.days16);
//        days17 = (TextView) findViewById(R.id.days17);

        fillText();
    }

    //por kardan resume
    public void fillText() {
        days1.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("habitg1", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitgp1", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitg2", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitgp2", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitg3", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitgp3", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitb1", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitbp1", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitg2", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitbp2", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitb3", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("habitbp3", ""));
        days2.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("reflex", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("reflexAmel", ""));
        models = Days3DB.listAll(Days3DB.class);
        adapter = new Days3Adapter(models, mContext);
        mylist = (ListView) findViewById(R.id.days3_4);
        mylist.setAdapter(adapter);
        days5.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("obligation", ""));
        days6.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("lecture", ""));
        days7.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("dream", ""));
        days8.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("way", ""));
        days9.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("resalat", ""));
        days10.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("canon", ""));
        days11.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("law", ""));
        days12.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("life", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("job", ""));
        days13.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("leader", "")
                + "\n" + PreferenceManager.getDefaultSharedPreferences(this).getString("manage", ""));
        days17.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("manage", ""));

    }
}
