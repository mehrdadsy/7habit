package ir.mehrdadseyfi.a7habit.TwentyOneDays;

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

import java.text.DateFormat;
import java.util.Date;

import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;

public class MainStart21DayActivity extends AppCompatActivity {
    Button btnStart;
    TextView textView;
    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start21_day);
        if( PreferenceManager.getDefaultSharedPreferences(this).getBoolean("startsate",false)){
            Toast.makeText(mContext, "تمرین یکباز اغاز شده است", Toast.LENGTH_SHORT).show();
            finish();
        }

        btnStart = (Button) findViewById(R.id.start_21day);
        textView = (TextView) findViewById(R.id.txt);
        textView.setText("به نام خدا");
        TextView textView1 = (TextView) findViewById(R.id.txt1);
        textView1.setText("این مجموعه تمرین بر اساس کتاب پر فروش هفت عادت مردمان موفق تهیه شده است.این تمرین ها در کنار سه قسمت اصلی دیگر برنامه که شامل برنامه ریزی روزانه،مربع الویت بندی کارها،اهداف، به شما در راه موفقیت و پیشرفت کمک خواهد کرد." +
                "دستور العمل های اجرا این تمرین ها به شرح ذیل است:" +
                "هر تمرین مدت زمان یک روز از زمان اتمام تمرین قبلی باید فاصله زمانی داشته باشد." +
                "لطفا به سوال ها موجود در برنامه با دقت پاسخ دهید." +
                "این تمرین ها به مدت 21 روز به طول خواهد انجامید" +
                "در صورت داشتن هر گونه سوال با تلگرام و یا ایمیل موسسه در ارتباط باشید" +
                "برای شروع تمرین ها بروی دکمه زیر کلیک نمایید");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putBoolean("startsate", true).commit();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", 1).commit();
                finish();


            }
        });

    }

}
