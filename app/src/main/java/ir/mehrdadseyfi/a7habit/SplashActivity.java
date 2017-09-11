package ir.mehrdadseyfi.a7habit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ir.mehrdadseyfi.a7habit.TwentyOneDays.TwentyOneDaysActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, TwentyOneDaysActivity.class));
                    finish();
                }

            }, 2500);
        }
    }

