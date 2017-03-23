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

        Button bricks = (Button) findViewById(R.id.bricks);
        bricks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.BRICKS");
                startActivity(pushnot);
            }
        });

        Button conquest = (Button) findViewById(R.id.conquest);
        conquest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.CONQUEST");
                startActivity(pushnot);
            }
        });

        Button bombdisposal = (Button) findViewById(R.id.bombdisposal);
        bombdisposal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.BOMBDISPOSAL");
                startActivity(pushnot);
            }
        });
    }
}
