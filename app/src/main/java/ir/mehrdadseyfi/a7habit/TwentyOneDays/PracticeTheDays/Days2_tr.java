package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days2_tr extends AppCompatActivity {
    Context mContext = this;
    EditText reflex ;
    EditText reflexAmel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days2_tr);
        reflex = (EditText) findViewById(R.id.reflex);
        reflexAmel = (EditText) findViewById(R.id.reflex_amel);
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(reflex.getText()).matches("")&&String.valueOf(reflexAmel.getText()).matches("")){
                    Toast.makeText(mContext, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                }else {
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel",0)+1).commit();
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                    giveData();
                    alarmManager(Calendar.getInstance().getTime().getTime()+86400000);
                    finish();


                }
            }
        });
    }
    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("reflex", String.valueOf(reflex.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("reflexAmel", String.valueOf(reflexAmel.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days2_tr.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days2_tr.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
