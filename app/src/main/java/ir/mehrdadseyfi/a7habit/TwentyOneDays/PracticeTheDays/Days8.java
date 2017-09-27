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

public class Days8 extends AppCompatActivity {
    Context mContext = this;
    EditText way ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days8);
        TextView txt1=(TextView)findViewById(R.id.slide26_1);
        TextView txt=(TextView)findViewById(R.id.slide26_2);
        txt.setText("عادت 2 مبتنی بر اصول رهبری خویشتن است. به این معنا که رهبری، نخستین آفرینش است. رهبری، مدیریت نیست. مدیریت، دومین آفرینش است که در فصل مربوط به  ((عادت3)) درباره اش گفتگو خواهیم کرد. اما نخست رهبری باید بیاید.\n" +
                "مدیریت یعنی درست انجام دادن امور، رهبری انجام دادن امور درست.\n" +
                " مدیریت یعنی کارآیی در صعود نردبان ترقی؛ حال آنکه رهبری یعنی تشخیص این که آیا نردبان به دیوار درست تکیه دارد یا نه!\n");
        txt1.setText("همانگونه که پیش از این ملاحظه کردیم،" +"\n"+
                " عامل بودن مبتنی بر موهبت یکتا و انسانی خودآگاهی است. دو موهبت یکتای انسانی دیگر که مارا قادر به گسترش عامل بودن خود می سازند و اجازه می دهند که رهبری را در زندگی شخصی خود به کار گیریم عبارتند از تخیل و وجدان");
        //////// az roya dirouz por mishavad
        TextView txt3=(TextView)findViewById(R.id.dream_sozan);
        String dream = PreferenceManager.getDefaultSharedPreferences(this).getString("dream", "") ;
        way = (EditText) findViewById(R.id.way);
        txt3.setText(dream);
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(way.getText()).matches("")){
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

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("way", String.valueOf(way.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days8.this, NOEsstianlEmergencyMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days8.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
