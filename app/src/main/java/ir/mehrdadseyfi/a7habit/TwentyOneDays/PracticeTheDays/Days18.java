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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days18 extends AppCompatActivity {
    EditText days18_1;
    EditText days18_2;
    EditText days18_3;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days18);
        TextView page79 = (TextView) findViewById(R.id.page79);
        page79.setText("ما برای رفع مشکل مدیریت زمان باید تمرکز خود را از مربع سه و چهار بروی مربع دو بیاوریم" + "\n"
                + "باید به برخی از امور وسوسه انگیز و ظاهرا فوری نه بگوییم و از انجام یکسری امور لذتبخش نیز حذر کنیم زیرا باید وقت مان را به امور مهم برای ساختن تجارت مان اختصاص دهیم.");
        days18_1 = (EditText) findViewById(R.id.days18_1);
        days18_2 = (EditText) findViewById(R.id.days18_2);
        days18_3 = (EditText) findViewById(R.id.days18_3);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(days18_1.getText()).matches("")) {
                    Toast.makeText(mContext, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                } else {
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel", 0) + 1).commit();
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                    giveData();
                    alarmManager(Calendar.getInstance().getTime().getTime() + 10000);
                    finish();


                }
            }
        });
    }

    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("canon", String.valueOf(days18_1.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("canon", String.valueOf(days18_2.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("canon", String.valueOf(days18_3.getText())).commit();

    }

    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days18.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days18.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
