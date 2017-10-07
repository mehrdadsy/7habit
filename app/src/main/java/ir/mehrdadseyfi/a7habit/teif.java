package ir.mehrdadseyfi.a7habit;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Mehrdad on 10/7/2017.
 */

public class teif extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("iransans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}