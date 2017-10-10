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

public class Days19 extends AppCompatActivity {
    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days19);
        TextView page60=(TextView)findViewById(R.id.page60);
        page60.setText("هدف شما در این بخش این است که تمام آموخته های خود از درس هفت عادت مردمان موثر را به فرد دیگری آموزش دهید.در این کار هم شما سود می برید و هم کسی که گوش می دهد.در اولین فرصت این شخص را از قصد خود آگاه کنید،این کار تعهد شما را نشان می دهد."+"\n"
        );
        TextView page61=(TextView)findViewById(R.id.page61);
        page61.setText("برای شروع ابتدا به سوال های زیر در ذهن خود پاسخ بدهید"+"\n"
        +"چه کسی را باید اموزش دهید" +
                "چه زمانی قصد دارید او را از نیت خود آگاه کنید" +
                "چه زمانی این مطالب را به او اموزش می دهید");
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel", 0) + 1).commit();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();

                alarmManager(Calendar.getInstance().getTime().getTime() + 86400000);
                    finish();



            }
        });
    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days19.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days19.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
