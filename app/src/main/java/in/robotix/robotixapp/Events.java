package in.robotix.robotixapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Events extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_events, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentMain.addView(contentView, params);

        Button stax = (Button) findViewById(R.id.stax);
        stax.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.STAX");
                startActivity(pushnot);
            }
        });

        Button fortress = (Button) findViewById(R.id.fortress);
        fortress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.FORTRESS");
                startActivity(pushnot);
            }
        });

        Button polesapart = (Button) findViewById(R.id.polesapart1);
        polesapart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.POLES");
                startActivity(pushnot);
            }
        });
    }
}
