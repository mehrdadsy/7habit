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

public class Days6 extends AppCompatActivity {
    Context mContext = this;
    EditText lecture ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days6);
        TextView txt=(TextView)findViewById(R.id.slide23);
        txt.setText("ذهناً مجسم کنید که به مراسم خاک سپاری خود می روید.\n" +
                "در آن مراسم در مورد شما چه می گویند؟؟؟\n" +
                "مفهوم ((ذهناً از پایان آغاز کنید)) چیست؟\n" +
                "اگر به طور جدی تجربه بالا را مجسم کرده باشید، لحظه یی با ژرفترین و بنیادی ترین ارزشهای خود تماس یافته اید. در دل ((حلقه نفوذتان)) تماس کوتاهی با نظام هدایت درونی خود برقرار کرده اید.\n" +
                "((ذهناً از پایان آغاز کنید)) یعنی اینکه به روشنی مقصدتان را بشناسید. یعنی بدانید به کجا می روید، تا بتوانید بهتر دریابید که اکنون کجا هستید و گامهایی را که بر می دارید همواره در مسیر درست است.\n");

        lecture = (EditText) findViewById(R.id.lecture);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(lecture.getText()).matches("")){
                    Toast.makeText(mContext, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                }else {
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel",0)+1).commit();
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                    giveData();
                    alarmManager(Calendar.getInstance().getTime().getTime()+10000);
                    finish();


                }
            }
        });
    }
    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("lecture", String.valueOf(lecture.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days6.this, NOEsstianlEmergencyMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days6.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
