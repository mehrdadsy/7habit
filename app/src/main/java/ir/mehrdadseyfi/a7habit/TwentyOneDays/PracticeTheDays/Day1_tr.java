package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Day1_tr extends AppCompatActivity {
    Context mContext = this;
    EditText habitg1 ;
    EditText habitg2 ;
    EditText habitg3 ;
    EditText habitgp1 ;
    EditText habitgp2 ;
    EditText habitgp3 ;
    EditText habitb1 ;
    EditText habitb2 ;
    EditText habitb3 ;
    EditText habitbp1 ;
    EditText habitbp2 ;
    EditText habitbp3 ;
    EditText aboutMe ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_tr);
        habitg1 = (EditText) findViewById(R.id.habitg1);
        habitg2 = (EditText) findViewById(R.id.habitg2);
        habitg3 = (EditText) findViewById(R.id.habitg3);
        habitgp1 = (EditText) findViewById(R.id.habitgp1);
        habitgp2 = (EditText) findViewById(R.id.habitgp2);
        habitgp3 = (EditText) findViewById(R.id.habitgp3);
        habitb1 = (EditText) findViewById(R.id.habitb1);
        habitb2 = (EditText) findViewById(R.id.habitb2);
        habitb3 = (EditText) findViewById(R.id.habitb3);
        habitbp1 = (EditText) findViewById(R.id.habitbp1);
        habitbp2 = (EditText) findViewById(R.id.habitbp2);
        habitbp3 = (EditText) findViewById(R.id.habitbp3);
        aboutMe = (EditText) findViewById(R.id.about_me);
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(habitg1.getText()).matches("")&&String.valueOf(habitg2.getText()).matches("")&&String.valueOf(habitg3.getText()).matches("")&&String.valueOf(habitb1.getText()).matches("")&&String.valueOf(habitb2.getText()).matches("")&&String.valueOf(habitb3.getText()).matches("")&&String.valueOf(aboutMe.getText()).matches("")){
                    Toast.makeText(mContext, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                }else {
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel",0)+1).commit();
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                    giveData();
                    //86400000
                    alarmManager(Calendar.getInstance().getTime().getTime()+86400000);
                    finish();


                }
            }
        });


    }

    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitg1", String.valueOf(habitg1.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitg2", String.valueOf(habitg2.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitg3", String.valueOf(habitg3.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitgp1", String.valueOf(habitgp1.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitgp2", String.valueOf(habitgp2.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitgp3", String.valueOf(habitgp3.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitb1", String.valueOf(habitb1.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitb2", String.valueOf(habitb2.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitb3", String.valueOf(habitb3.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitbp1", String.valueOf(habitbp1.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitbp2", String.valueOf(habitbp2.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("habitbp3", String.valueOf(habitbp3.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("aboutMe", String.valueOf(aboutMe.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Day1_tr.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Day1_tr.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
