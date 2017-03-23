package in.robotix.robotixapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Home extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.home_dashboard);
        // To enable naviagtion drawer add -> android:theme="@style/AppTheme.NoActionBar" to manifest
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.home_dashboard, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentMain.addView(contentView, params);

        Button notice = (Button) findViewById(R.id.notice);
        Button events = (Button) findViewById(R.id.events);
        Button aboutus = (Button) findViewById(R.id.aboutus);
        Button faqs = (Button) findViewById(R.id.faqs);
        Button map = (Button) findViewById(R.id.map);
        Button contactus = (Button) findViewById(R.id.contactus);

        events.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.EVENTS");
                startActivity(pushnot);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.ABOUTUS");
                startActivity(pushnot);
            }
        });
        faqs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.FAQS");
                startActivity(pushnot);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.CONTACTUS");
                startActivity(pushnot);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.NOTICEBOARD");
                startActivity(pushnot);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.MAPS");
                startActivity(pushnot);
            }
        });
    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        }

    }
}
