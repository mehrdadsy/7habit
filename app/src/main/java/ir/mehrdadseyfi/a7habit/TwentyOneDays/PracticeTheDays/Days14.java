package ir.mehrdadseyfi.a7habit.TwentyOneDays.PracticeTheDays;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialItem;
import ir.mehrdadseyfi.a7habit.Esstinal.Noemergency.NoEmergencyEssntialActivity;
import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.SquareTasksActivity;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days14 extends AppCompatActivity {
 Context mContext=this;
    List<EmergencyEssntialItem> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days14);
        TextView txt=(TextView)findViewById(R.id.slide48);
        txt.setText("پیروزمندان به انجام کارهایی خو کرده اند که با زندگان از انجامش می گریزند و هرگز به آن تن در نمی دهند." +
                " حتی اگر پیروزمندان مایل به انجام کاری نباشند، این بی میلی از عزم و ارادۀ مستقل ایشان ناشی می شود.\n");
        findViewById(R.id.goToSquare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Days14.this, SquareTasksActivity.class));

            }
        });
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
            Intent intent = new Intent(Days14.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days14.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
