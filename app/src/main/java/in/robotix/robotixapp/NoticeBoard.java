package in.robotix.robotixapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.messaging.FirebaseMessaging;
import in.robotix.robotixapp.firebase.FirebaseConfig;

/**
 * Created by lenovo on 24-Jan-17.
 */

public class NoticeBoard extends AppCompatActivity{
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_not);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_not);
        collapsingToolbar.setTitle("Notice Board");

        // Load Notices
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_ROBOTIX, 0);
        String notices = pref.getString("notices",null);
        if (notices == null) {
            // putString
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("notices", "");
            editor.commit();
            notices = "";
        }
        else displayNotification(notices);

        // Listen to Firebase Broadcast Publisher
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            // checking for type intent filter
            /*if (intent.getAction().equals(FirebaseConfig.REGISTRATION_COMPLETE)) {
                // gcm successfully registered
                // now subscribe to `global` topic to receive app wide notifications
                //Can be done FirebaseMessaging.getInstance().subscribeToTopic(FirebaseConfig.TOPIC_GLOBAL);
            }*/
            if (intent.getAction().equals(FirebaseConfig.PUSH_NOTIFICATION)) {
                // new push notification is received
                String message = intent.getStringExtra("message");
                SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_ROBOTIX, 0);
                String notices = pref.getString("notices","");
                displayNotification(notices);
            }
            }
        };
    }

    private void displayNotification(String raw_data)
    {
        boolean invalidData = false;
        if(raw_data.length() > 0)
        {
            String[] all_Notifications = raw_data.split("~");
            String[] title = new String[all_Notifications.length];
            String[] details = new String[all_Notifications.length];
            String[] time = new String[all_Notifications.length];
            int j = 0;

            for(int i = all_Notifications.length-1; i>=0;i--)
            {
                String[] each_Notification = all_Notifications[i].split("\\^");
                if(each_Notification.length == 3)
                {
                    title[j] = each_Notification[0];
                    details[j] = each_Notification[1];
                    time[j] = each_Notification[2];
                    j++;
                }
                else invalidData = true;
            }
            if (invalidData){
                resetNotices();
            }
            else if(title.length>0)
            {
                ListView listview = (ListView) findViewById(R.id.listview_not);
                listview.setAdapter(new notificationViewAdapter(this, title, details, time));
            }
        }
    }

    private void resetNotices(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_ROBOTIX, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("notices", "");
        editor.commit();
        Log.e("NoticeBoard", "Overwritten to notices sp: " + "");
    }

    @Override
    public void onBackPressed() {
        Intent pushnot = new Intent("in.robotix.robotixapp.HOME");
        startActivity(pushnot);
        finish();
    }
}