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
import java.util.List;

import ir.mehrdadseyfi.a7habit.Emegency.EmergencyEssntialItem;
import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.SquareTasksActivity;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days15 extends AppCompatActivity {
    Context mContext=this;
    List<EmergencyEssntialItem> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days15);
        TextView txt=(TextView)findViewById(R.id.slide50);
        txt.setText("به تعبیر پیتر دراکر، افراد مؤثر هرگز مسایل را مرکز توجه قرار نمی دهند بلکه ذهن را به فرصتها و راه حلها معطوف می دارند." +
                " در حقیقت آنان به فرصتها خوراک می رسانند و مسائل را دچار گرسنگی می کنند؛ قاطعانه می اندیشند؛ به ضرورتها و بحرانها مربع 1 بی توجهند و با تمرکز به مارهای ضروری و غیرو فوریتی مربع 2 اهرم نیرومندی را در اختیار گرفته، بین تولید و قابلیت تولید تعادل برقرار می کنند.\n");
        TextView txt1=(TextView)findViewById(R.id.slide52_1);
        TextView txt2=(TextView)findViewById(R.id.slide52_2);
        txt1.setText("ابزار مربع 2 : هدف آن نیست که اجزای برنامۀ خود را اولیت بندی کنید، مقصود آن است که اولویتهای کار و زندگیتان را به نظم درآورید.");
        txt2.setText("هدف مدیریت مربع 2، ادارۀ زندگی ما به گونه ای مؤثر است." +
                " برای دستیابی به این مقصود، اصول درست و منطقی و رسالت فردی کانون توجه قرار می گیرد به ضرورت هر کار به اندازۀ فوریت آن بها داده می شود و همه اینها در چارچوب حفظ توازن بین افزایش تولید و افزایش توانایی تولیدما، ارزیابی می شود.\n");
        findViewById(R.id.goToSquare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Days15.this, SquareTasksActivity.class));

            }
        });
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
            Intent intent = new Intent(Days15.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days15.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
