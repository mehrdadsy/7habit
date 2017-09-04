package ir.mehrdadseyfi.a7habit.TwentyOneDays;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import ir.mehrdadseyfi.a7habit.AlarmSoundService;
import ir.mehrdadseyfi.a7habit.NOEsstianlEmergency.AlarmNotificationServiceNOEsstianlEmergency;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by admin on 8/23/2017.
 */

public class TODMyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context con, Intent arg1) {

        Toast.makeText(con,"Alarm",Toast.LENGTH_LONG).show();
        con.startService(new Intent(con, AlarmSoundService.class));
        ComponentName comp = new ComponentName(con.getPackageName(),TODAlarmNotificationService.class.getName());
        startWakefulService(con,(arg1.setComponent(comp)));


    }

}