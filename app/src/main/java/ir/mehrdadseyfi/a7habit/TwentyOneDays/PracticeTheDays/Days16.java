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
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import ir.mehrdadseyfi.a7habit.Calender.CalenderActivity;
import ir.mehrdadseyfi.a7habit.NOEmergencyNoEsstial.NOEsstianlEmergencyMyReceiver;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.SquareTasksActivity;
import ir.mehrdadseyfi.a7habit.Vista.FGdatabase;
import ir.mehrdadseyfi.a7habit.Vista.VistaActivity;

public class Days16 extends AppCompatActivity {
    List<FGdatabase> models;
    Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days16);
        TextView txt = (TextView) findViewById(R.id.slide54);
        TextView txt1 = (TextView) findViewById(R.id.slide55);
        TextView txt2 = (TextView) findViewById(R.id.slide56);
        TextView txt3 = (TextView) findViewById(R.id.slide57);
        TextView txt4 = (TextView) findViewById(R.id.slide58);
        TextView txt5 = (TextView) findViewById(R.id.slide59);
        TextView txt6 = (TextView) findViewById(R.id.slide60);
        TextView txt7 = (TextView) findViewById(R.id.slide61);
        TextView txt8 = (TextView) findViewById(R.id.slide62);
        TextView txt9 = (TextView) findViewById(R.id.slide63);
        txt.setText("ارتباط مفهوم آن است که بین بینش، رسالت، نقشها و اهداف، برنامه ها، اولویتها، تمایلات و نظم و ترتیب شما، اتحاد، هماهنگی و انسجام وجود دارد. در صدر برنامۀ زمانبندی شعار رسالت فردی خود را بنویسید تا بتوانید به طور مداوم آن را مد نظر داشته باشید. " +
                "همچنین محلی را برای نقشها و اهداف کوتاه و بلند مدت خود در نظر بگیرید.\n");
      txt1.setText("ابزاری که در اختیار دارید باید بتواند شما را در ایجاد توازن در زندگی یاری کند؛" +
              " تا بتوانید نقشهای گوناگون خود را در زندگی شناخته  پیش رو داشته باشید و هرگز در جنبه های مهم زندگی از قبیل تندرستی، روابط خانوادگی، ارتقاء شخصیت و کسب کار قصور نورزید.\n");
      txt2.setText("شما به اهرمی نیازمندید که در شما انگیزه بیافریند و یاریتان کند تا وقت لازم را در مربع 2 سپری کنید.\n" +
              "به این ترتیب به جای اینکه نداسته به بروز بحرانها دامن بزنید، از وقوع آن جلوگیری خواهید کرد. به اعتقاد من بهترین شیوۀ برای انجام این مهم سازماندهی زندگی بر اساس یک برنامه هفتگی است. البته این امر هیچ تناقصی با اولویت بندی برنامۀ روزانه ندارد. اما مبنای اصلی، سازماندهی روزهای هفته است چرا که تعادل برنامۀ هفتگی به مراتب بیشتر از توازن برنامۀ روزانه است.\n");
      txt3.setText("شما محتاج ابزاری هستید که نه تنها برنامه ها ، که نقش مردم را نیز به حساب آورد. فرد مبتنی بر اصول ضمن بهره برداری بیشتر از زمان، تأثیر گذاری بر مردم را نیز مرکز توجه قرار می دهد/ بعضی اوقات زندگی متکی به اصول (مربع2) وادارتان می کند تا کارهای مردم را بر اهداف خود مقدم شمرید.\n");
      txt4.setText("ابزار برنامه ریزی باید همواره فرمانبردار شما باشد و نه آمر و فرمان دهنده." +
              " این اهرم برای خدمت به شما، باید دقیقاً با اوضاع و شرایط نیازها  خصوصیات شما جور و هماهنگ باشد.\n");
      txt5.setText("ابزار برنامه ریزی باید قابل حمل باشد،" +
              " چناچه بتوانید در بیشتر مواقع آن را با خود حمل کنید.\n");
      txt6.setText("شناسایی نقشها- اولین قدم تعیین نقشها اساسی زندگی است. " +
              "اگر تا به حال به طور جدی به وظایف خود در زندگی نیندیشیده اید، می توانید آنچه را که بلافاصله به ذهنتان خطور می کند، یادداشت کنید. \n");
      txt7.setText("انتخاب اهداف- دومین قدم اندیشیدن به دو یا سه کار ضروری است که احساس می کنید بایستی در طول هفته آینده به مرحله اجرا گذارید، این فعالیتها به عنوان اهداف شما ثبت می شوند.\n" +
              "دست کم بعضی از این اهداف باید بازتاب فعالیتهای مربع 2 باشد. کمال مطلوب آن است که اهداف کوتاه مدت به اهداف بلند مدتی که پیش از این تعیین کرده اید و با شعار رسالت فردی شما هماهنگ است، متصل شود.\n");
      txt8.setText("برنامه زمانبندی- اینک می توانید در حالیکه اهدافی را در ذهن دارید، اوقات هفتۀ آینده را زمانبندی کنید." +
              " برای مثال اگر هدفتان تعیین پیش نویس رسالت فردی است می توانید دو ساعت از اوقات روز یکشنبه را به این کار اختصاص دهید.\n");
      txt9.setText("فراموش نکنید که ناکامی ناشی از انتظارات ماست و وانتظارات ما به جای اینکه از اولویتها و ارزشهایمان نشأت گیرد اغلب حاصل الگوهای اجتماع است.\n");
   findViewById(R.id.goCal).setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {


              startActivity(new Intent(Days16.this, CalenderActivity.class));

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
            Intent intent = new Intent(Days16.this, NOEsstianlEmergencyMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days16.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
}
