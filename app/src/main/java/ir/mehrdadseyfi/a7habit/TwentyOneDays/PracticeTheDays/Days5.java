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
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TODMyReceiver;

public class Days5 extends AppCompatActivity {
    Context mContext = this;
    EditText obligation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days5);
        TextView txt=(TextView)findViewById(R.id.slide19);
        txt.setText("گاه عامل ترین کاری که می توانیم بکنیم شاد بودن، است:" +
                " فقط لبخندی راستین. خوشبختی انتخابی عامل است.\n");
        TextView txt1=(TextView)findViewById(R.id.slide20);
        txt1.setText("در دل ((حلقه نفوذمان)) توانایی ایجاد تعهد و حفظ تعهد و وفا کردن به عهدهایمان.))" +
                " خودمان و دیگران – نهفته است. به انجام رساندن آن تعهدات و پیمانها، جوهر و روشنترین تجلی عامل بودن ماست.\n");
        TextView txt2=(TextView)findViewById(R.id.slide20);
        txt2.setText("قدرت با خود عهد بستن و بر سر این عهد ایستادن،" +
                " جوهر پرورش عادتهای بنیادی کارآیی است.\n");
        obligation = (EditText) findViewById(R.id.obligation);

        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(obligation.getText()).matches("")){
                    Toast.makeText(mContext, "لطفا تمامی فیلد ها را پر کنید", Toast.LENGTH_SHORT).show();
                }else {
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel",0)+1).commit();
                    PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("t0", Calendar.getInstance().getTime().getTime()).commit();
                    giveData();
                    alarmManager(Calendar.getInstance().getTime().getTime()+86400000);
                    finish();


                }
            }
        });
    }
    public void giveData() {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("obligation", String.valueOf(obligation.getText())).commit();

    }
    public void alarmManager(long d) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);


        if (d > 0) {
            Intent intent = new Intent(Days5.this, TODMyReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(Days5.this, 1, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, d, pi);
        }
    }
    }

