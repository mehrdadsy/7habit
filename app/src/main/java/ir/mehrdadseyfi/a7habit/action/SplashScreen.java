package ir.mehrdadseyfi.a7habit.action;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

import java.util.Locale;

import ir.mehrdadseyfi.a7habit.R;
import ir.mehrdadseyfi.a7habit.action.service.PortDiscoveryService;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
public class SplashScreen extends Activity {
    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Locale locale = new Locale("ir");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.main);
        PortDiscoveryService.discoverOpenPortInBackground();

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
