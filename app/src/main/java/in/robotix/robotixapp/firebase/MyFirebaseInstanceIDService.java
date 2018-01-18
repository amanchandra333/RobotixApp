package in.robotix.robotixapp.firebase;

/**
 * Created by lenovo on 25-Jan-17.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import in.robotix.robotixapp.Config;
import in.robotix.robotixapp.firebase.FirebaseConfig;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Saving reg id to shared preferences
        storeRegIdInPref(refreshedToken);

        // sending reg id to your server
        sendRegistrationToServer(refreshedToken);

        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(FirebaseConfig.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", refreshedToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
        FirebaseMessaging.getInstance().subscribeToTopic(FirebaseConfig.TOPIC_GLOBAL);
        FirebaseMessaging.getInstance().subscribeToTopic(FirebaseConfig.TOPIC_STAX);
        FirebaseMessaging.getInstance().subscribeToTopic(FirebaseConfig.TOPIC_POLESAPART);
        FirebaseMessaging.getInstance().subscribeToTopic(FirebaseConfig.TOPIC_FORTRESS);
    }

    private void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        Log.e(TAG, "sendRegistrationToServer: " + token);
        //String returnData = postData(FirebaseConfig.REG_SERVER,"regID",token);
        //if(!returnData.equals("-1")) overWriteToSP(token);
    }

    private void storeRegIdInPref(String token) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(FirebaseConfig.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }

    /**
     * Overwrite notification message to shared preference
     */
    private void overWriteToSP(String message){
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_ROBOTIX, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("notices", message);
        editor.commit();
        Log.e(TAG, "Overwritten to notices sp: " + message);
    }

    public String postData(String sURL,String key,String sData)
    {
        try
        {
            String data = URLEncoder.encode(key, "UTF-8")+ "=" + URLEncoder.encode(sData, "UTF-8");
            URL url = new URL(sURL);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            Log.e(TAG, "POST Respon "+sb.toString());
            return sb.toString();

        }catch(Exception e)
        {
            Log.e(TAG, "Cannot Post");
            return "-1";
        }
    }
}
