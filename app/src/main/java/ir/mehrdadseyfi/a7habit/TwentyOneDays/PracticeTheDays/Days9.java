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

public class Days9 extends AppCompatActivity {
    Context mContext = this;
    EditText resalat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days9);
        TextView txt = (TextView) findViewById(R.id.slide30);
        txt.setText("هنگامی که درون حلقه نفوذمان به کار سرگرمیم، آن را گسترش می بخشیم." +
                " این بالاترین اهرم برای افزایش قابلیت تولید است، و به طرزی قابل ملاحظه بر همه جنبه های زندگیمان تأثیر می گذارد.\n");
        TextView txt1 = (TextView) findViewById(R.id.slide28_1);
        txt1.setText("مؤثرترین راهی که برای ((ذهناً از پایان آغاز کنید)) می شناسیم،" +
                "ایجاد حکم یا فلسفه یا شعار رسالت شخصی است. این حکم بر آنچه می خواهید باشید (منش) و آنچه می خواهید به انجام برسانید (خدمات و توفیقها) و ارزشها یا اصولی که ((بودن و کنش)) بر اساس آنند متمرکز می شود.\n");
        TextView txt2 = (TextView) findViewById(R.id.slide29_2);
        txt2.setText("برای نوشتن شعار رسالت شخصی خود باید از کانون حلقه نفوذمان- از هسته یی که بنیادی ترین برداشتهایمان را در بر می گیرد،" +
                " و عینکی که توسط آن جهان را می نگریم- آغاز کنیم.\n");
        resalat = (EditText) findViewById(R.id.resalat);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(resalat.getText()).matches("")) {
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

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("dream", String.valueOf(resalat.getText())).commit();

    }

    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days9.this, NOEsstianlEmergencyMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days9.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}

