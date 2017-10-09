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

public class Days13 extends AppCompatActivity {
    Context mContext = this;
    EditText leader;
    EditText manage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days13);
        TextView txt=(TextView)findViewById(R.id.slide45);
        txt.setText("بعد از خود آگاهی،" +
                " قوۀ تخیل و وجدان، چهارمین موهبت منحصر به فرد انسان نیروی اراده مستقل است که راه را برای احراز مقام شامخ مدیریت مؤثر نفس هموار می کند: توانایی تصمیم گیری درست و عمل به آن؛ توانایی تأثیرگذاری به جای تأثیر پذیری و اجرای عاملانه برنامه ای که تا کنون به وسیله سه موهبت دیگر بسط و توسعه داده ایم.\n");
        leader = (EditText) findViewById(R.id.leader);
        manage = (EditText) findViewById(R.id.manage);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(leader.getText()).matches("")&&String.valueOf(manage.getText()).matches("")) {
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

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("leader", String.valueOf(leader.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("manage", String.valueOf(manage.getText())).commit();

    }

    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days13.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days13.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
