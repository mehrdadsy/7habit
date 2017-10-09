package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days20 extends AppCompatActivity {
    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days20_edit);
        TextView page99_3=(TextView)findViewById(R.id.page99_3);
        page99_3.setText("تنها شخصی که روی آن کنترل مستقیم و کامل دارید خودتان هستید." +
                "پس بزرگترین دارایی شما که باید دائما آن را حفظ و تقویت کنید قابلیت های خودتان است.هیچ کس نمی تواند این کار را به جای شما انجام دهد." +
                "تیز کردن اره به معنی حفظ قابلیت تولید و خلاقیت شخصی است." +
                "اره را تیز کردن تجدید قوا خود در هر چهار بعد شما یعنی جسمی،روحی،ذهنی،و عواطف اجتماعی است.");
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel", 0) + 1).commit();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();

                alarmManager(Calendar.getInstance().getTime().getTime() + 10000);
                finish();



            }
        });
    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days20.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days20.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
