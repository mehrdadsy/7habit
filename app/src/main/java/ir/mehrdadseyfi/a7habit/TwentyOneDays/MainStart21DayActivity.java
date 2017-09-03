package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

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
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString("t0", currentDateTimeString).commit();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putBoolean("startsate", true).commit();
                finish();


            }
        });

    }
}
