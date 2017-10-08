package ir.mehrdadseyfi.a7habit;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Mehrdad on 10/8/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}