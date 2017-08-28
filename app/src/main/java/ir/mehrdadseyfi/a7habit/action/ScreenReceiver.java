package ir.mehrdadseyfi.a7habit.action;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
public class ScreenReceiver extends BroadcastReceiver {
    public static boolean isScreenOn = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            // do whatever you need to do here
            isScreenOn = false;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // and do whatever you need to do here
            isScreenOn = true;
        }
    }
}