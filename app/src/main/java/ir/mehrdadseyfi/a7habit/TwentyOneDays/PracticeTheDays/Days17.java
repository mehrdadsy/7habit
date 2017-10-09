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

import java.util.Calendar;

import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days17 extends AppCompatActivity {
    Context mContext=this;
    EditText day17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days17);
        TextView txt=(TextView)findViewById(R.id.slide64);
        txt.setText("مبتنی بر اصول است."+"\n"+"تابع وجدان است"+"\n"+"رسالت منحصر به فرد شما را که شامل ارزشها و اهداف درازمدت شماست توصیف و جهت و مقصود هر روز زندگیتان را تعیین می کند."+"\n"+"یاریتان می کند تا با شناخت وظایف، هدف گذاری و برنامه ریزی مسئولیتهای روزهای هفته، زندگیتان را متعادل کنید");
        TextView txt1=(TextView)findViewById(R.id.slide65_1);
        TextView txt2=(TextView)findViewById(R.id.slide65_2);
        txt1.setText("ما همه کارهای خود را با واگذاری به زمان یا فردی دیگر به مرحله اجرا می گذاریم. اگر کاری را به زمان واگذار کنیم،" +
                " به راندمان می اندیشیم واگر به دیگری تفویض اختیار کنیم به تأثیر گذاری و نفوذ فکر می کنیم.\n");
        txt2.setText("تفویض اختیار مؤثر نیرومندترین اهرم در پیشبرد کارها به شمار می آید.\n" +
                "انتقال مسئولیت به افراد ماهر و آموزش دیده به شما امکان می دهد که نیروی خود را به کارهای مهمتر اختصاص دهید.\n");
day17=(EditText)findViewById(R.id.days17);

        TextView txt3=(TextView)findViewById(R.id.slide67);
        txt3.setText("این نوع تفوض اختیار به جای روشها، نتایج را کانون توجه قرار می دهد." +
                " به بیانی دیگر انتخاب روش را به عهده افراد گذاشته و تنها ایشان را مسئول نتایج می شناسد.\n" +
                "تفویض اختیار ناظر حاصل درک متقابل و روشن و تعهد نسبت به انتظاراتی است.\n");
        TextView txt4=(TextView)findViewById(R.id.slide68);
                txt4.setText("تفویض اختیار ناظر در پنج مورد زیر خلاصه می شود:\n" +
                        " نتایج دلخواه\n" +
                        "راهنماها\n" +
                        "منابع\n" +
                        "معیارها\n" +
                        "نتایج\n");
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel", 0) + 1).commit();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                giveData();
                alarmManager(Calendar.getInstance().getTime().getTime() + 10000);
                finish();



            }
        });
    }
    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("manage", String.valueOf(day17.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days17.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days17.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
