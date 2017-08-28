package ir.co21.android.scorm.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
public class SecurityManager {
    private static final String TAG = "SecurityManager";
    private Context context;
    private SharedPreferences preferences;
    private static final String PREFERENCE_NAME = "androidLevelOfServiceStatus";
    private String status = "status";
    public SecurityManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);

    }

    public boolean getActivationStatus(){
        String preferencesString = preferences.getString(status, "THE STATUS IS: UNDEFINED");
        Log.d(TAG, preferencesString);
        return false;
    }

    public void storeActivationResponse(String activationResponse){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(status, activationResponse);
        editor.commit();
    }

    public String createActivationRequest(String productId, String subProductId, String serialNumber){
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        return deviceId;
    }

    public boolean verifyActivationResponse(String response){
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        return deviceId.equals(response);
    }

}
