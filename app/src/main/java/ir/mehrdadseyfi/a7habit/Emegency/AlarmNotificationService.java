package ir.mehrdadseyfi.a7habit.Emegency;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import ir.mehrdadseyfi.a7habit.R;

/**
 * Created by admin on 8/24/2017.
 */

public class AlarmNotificationService extends IntentService {
    private NotificationManager alarmNotificationManager;

    //Notification ID for Alarm
    public static final int NOTIFICATION_ID = 1;

    public AlarmNotificationService() {
        super("AlarmNotificationService");
    }

    @Override
    public void onHandleIntent(Intent intent) {

        //Send notification
        sendNotification("Wake Up! Wake Up! Alarm started!!");
    }

    //handle notification
    private void sendNotification(String msg) {


        Intent intent = new Intent(this, EmergencyEssntialActivity.class);

        intent.putExtra("key" , "value") ;

        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        Notification notif = new NotificationCompat.Builder(this)

                .setContentTitle("زمان انجام یه کار ضروری و اضطراری رسیده")

                .setContentText("")

                .setSmallIcon(R.mipmap.ic_launcher)

                .setContentIntent(pIntent)

                .setAutoCancel(true)

                .addAction(R.mipmap.ic_launcher, "دیدن", pIntent).build();



        NotificationManager notificationCompatManager =

                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationCompatManager.notify(0, notif);

    }


}