package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.mehrdadseyfi.a7habit.R;

public class ShowTipActivity extends AppCompatActivity {
Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tip);
        findViewById(R.id.sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putInt("curlevel", PreferenceManager.getDefaultSharedPreferences(mContext).getInt("curlevel",0)+1).commit();
                finish();

            }
        });
    }
}
