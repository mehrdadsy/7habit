package ir.mehrdadseyfi.a7habit.action;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import ir.mehrdadseyfi.a7habit.Calender.CalenderActivity;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.TwentyOneDays.TwentyOneDaysActivity;
import ir.mehrdadseyfi.a7habit.action.service.PortDiscoveryService;


public class SplashScreen extends Activity {
    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 6000;
    ImageView anima;
    TextView co_21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
         anima=(ImageView)findViewById(R.id.anim);
        co_21=(TextView)findViewById(R.id.co_21);
        //set anim
        final Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        final Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        anima.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                anima.startAnimation(animation1);
                co_21.setText("موسسه آموزشی مربیان 21");
            }
        }, 2000);
        anima.startAnimation(animation);

        PortDiscoveryService.discoverOpenPortInBackground();
        Locale locale = new Locale("ir");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AndroidWebServer.setContext(getApplicationContext());
                AndroidWebServer.start();
                Intent i = new Intent(SplashScreen.this, ScormPlayerActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}
