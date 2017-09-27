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

public class Days12 extends AppCompatActivity {
    Context mContext = this;
    EditText life;
    EditText job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days12);
        TextView txt=(TextView)findViewById(R.id.slide43);
        txt.setText("قبل از هر چیزی بهتر است به تجزیه و تحلیل عادت 3 بپردازیم. عادت 3 جلوه عملی عادتهای 1 و 2 نمایانگر بهره و ثمره زندگی فردی شماست.\n" +
                "عادت 1 می گوید شما آفریننده و مسئول اعمال خویشید. این عادت بر اساس چهار موهبت منحصر به فرد انسان یعنی قوه تخیل، وجدان، اراده آزاد و به ویژه خود آگاهی پی ریزی شده است. این عادت در شما این توانایی را پدید می آورد که جسورانه بگویید: ((این دیدگاه یا برنامه ذهنی ناسالم از دوران کودکی بر من تحمیل شده است. از آن بیزارم و می توانم تغییرش دهم.))\n" +
                "عادت 2 درباره اولین خلقت یا آفرینش ذهن است که بر پایه قوه تخیل استوار است.\n" +
                "توانایی تجسم، مشاهدۀ تواناییهای باطنی؛ مشاهدۀ چیزهایی که چشم به طور معمول از دیدنش عاجز است. و وجدان: توانایی درک و تشخیص خصوصیات منحصر به فرد و رهنمودهای اخلاقی، فردی و معنوی که در پرتوی آن می توان به رستگاری  رسید وجدان یا دیدگاه، بینش و ارزشهای اساسی ما ارتباط تنگاتنگ دارد. به این ترتیب عادت3 به دومین خلقت آفرینش جسم مرتبط است و تجلی و تبلور طبیعی عادهای 1 و 2 محسوب می شود. اراده مستقل چارچوبی برای زندگی مبتنی بر اصول است.\n");
        life = (EditText) findViewById(R.id.life);
        job = (EditText) findViewById(R.id.job);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(life.getText()).matches("")&&String.valueOf(job.getText()).matches("")) {
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

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("life", String.valueOf(life.getText())).commit();
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("job", String.valueOf(job.getText())).commit();

    }

    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days12.this, NOEsstianlEmergencyMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days12.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
