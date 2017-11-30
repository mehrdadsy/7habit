package ir.mehrdadseyfi.a7habit.action;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

import ir.mehrdadseyfi.a7habit.IsActive;
import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.action.service.PortDiscoveryService;


public class SplashScreen extends Activity {
    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 4000;
    ImageView anima;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
         anima=(ImageView)findViewById(R.id.anim);
        logo=(ImageView)findViewById(R.id.logo);
        IsActive book = new IsActive(false);
        book.save();

        //set anim
        final Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        final Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        anima.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                anima.startAnimation(animation1);
                logo.setImageResource(R.drawable.logo);
                logo.startAnimation(animation);

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
