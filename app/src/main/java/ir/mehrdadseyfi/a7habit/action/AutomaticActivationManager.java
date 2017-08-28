package  ir.mehrdadseyfi.a7habit.action;

import android.content.SharedPreferences;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import  ir.mehrdadseyfi.a7habit.action.service.ActivationService;
import  ir.mehrdadseyfi.a7habit.action.service.OfflineActivationClient;

/**
 * @author Sam
 * @version 1.0
 */
public class AutomaticActivationManager implements ActivationManager {
    private static final String ACTIVATION_CODE_KEY = "activation-code";
    private static final String SMS_STATUS = "sms_status";
    private static final String ACTIVATION_SERIAL_CODE = "serial-code";
    private SharedPreferences preferences;
    private String serverAddress;
    private String serviceAddress;
    private String serialId;
    private String deviceId;
    private static final String META_ID = "android-scorm-player";
    private String subId;
    private ActivationService activationService;
    private String userActivationCode;

    public AutomaticActivationManager(String serverAddress, String serviceAddress, String deviceId, String subId, SharedPreferences preferences) {
        this.preferences = preferences;
        this.serverAddress = serverAddress;
        this.serviceAddress = serviceAddress;
        this.deviceId = deviceId;
        this.subId = subId;
        activationService = new OfflineActivationClient();
    }

    @Override
    public String getSerialId() {
        return serialId;
    }
    @Override
    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }
    @Override
    public String getUserActivationCode() {
        return userActivationCode;
    }
    @Override
    public void setUserActivationCode(String userActivationCode) {
        this.userActivationCode = userActivationCode;
    }

    @Override
    public boolean isActive() {
        String activationCode = preferences.getString(ACTIVATION_CODE_KEY, null);
        try {
            if(activationCode == null) {
                throw new NullPointerException("Not activated yet.");
            }
            activationService.validate(

                    META_ID,
                    subId,
                    deviceId,
                    serialId,
                    activationCode
            );
            return true;
        } catch (Throwable ignored) {
            return false;
        }
    }

    @Override
    public void activate() {
        if (isActive()) {
            Log.d("Activation", "Already active.");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            AndroidHttpClient httpClient = AndroidHttpClient.newInstance("Android");
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("productId", META_ID));
            parameters.add(new BasicNameValuePair("deviceId", deviceId));
            parameters.add(new BasicNameValuePair("courseId", subId));
            parameters.add(new BasicNameValuePair("serial", serialId));
            HttpGet httpGet = new HttpGet(serverAddress + serviceAddress + "?" + URLEncodedUtils.format(parameters, "utf-8"));
            try {
                HttpResponse response = httpClient.execute(httpGet);
                StatusLine statusLine = response.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                Log.d("JSON", "Response code is : " + statusCode + " - " + statusLine);
                HttpEntity entity = response.getEntity();
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
                JSONObject result = new JSONObject(stringBuilder.toString());
                Log.d("WS", "Web service call result is : " + result);

                String activationCode = result.get("activationCode").toString();
                preferences.edit().putString(ACTIVATION_CODE_KEY, activationCode).apply();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("readJSONFeed", "Message" + e.getLocalizedMessage());
            } finally {
                httpClient.close();
            }
        }
    }

    @Override
    public void offlineActivate() {
        if (isActive()) {
            Log.d("Activation", "Already active.");
        } else {
            try {
                Log.d("ACTIVATION", "posted userActivationCode code is : " + userActivationCode);
                String activationCode = this.userActivationCode;
                preferences.edit().putString(ACTIVATION_CODE_KEY, activationCode).apply();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("readJSONFeed", "Message" + e.getLocalizedMessage());
            } finally {
            }
        }
    }

    @Override
    public boolean haveSerialCode() {
        boolean result;
        String serialCode = preferences.getString(ACTIVATION_SERIAL_CODE, null);
        if(serialCode == null) {
            result = false;
        }
        else {
            result = true;
        }
        return  result;
    }

    @Override
    public boolean inSmsStatus() {
        boolean result;
        Boolean smsStatus = preferences.getBoolean(SMS_STATUS, false);
        /*if(smsStatus == null) {
            result = false;
        }
        else {
            result = true;
        }*/
        result = smsStatus;
        return  result;
    }

    @Override
    public String getSerialCodeOfUser() {
        String activationSerialCode = preferences.getString(ACTIVATION_SERIAL_CODE, null);
        try {
            if(activationSerialCode == null) {
                throw new NullPointerException("Dont have serial code.");
            }

            return activationSerialCode;
        } catch (Throwable ignored) {
            return "";
        }
    }

    @Override
    public void setSerialCodeOfUser() {
        if (haveSerialCode()) {
            Log.d("Activation", "Already have serial code.");
        } else {
            try {
                String serialCode = this.serialId;
                preferences.edit().putString(ACTIVATION_SERIAL_CODE, serialCode).apply();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("readJSONFeed", "Message" + e.getLocalizedMessage());
            } finally {
            }
        }
    }

    @Override
    public void setSmsStatus(boolean smsStatus) {
        if (inSmsStatus()) {
            Log.d("Activation", "Already Is in sms Status.");
        } else {
            try {
                preferences.edit().putBoolean(SMS_STATUS, smsStatus).apply();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("readJSONFeed", "Message" + e.getLocalizedMessage());
            } finally {
            }
        }
    }
}
