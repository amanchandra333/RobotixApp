package in.robotix.robotixapp;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONObject;

import in.robotix.robotixapp.Config;

/**
 * Created by lenovo on 24-Jan-17.
 */

public class Polesapart extends NavigationDrawer{
    final Context context = this;
    Config mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_polesapart, null, false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentMain.addView(contentView, params);
        mConfig = new Config(this);

        // Buttons
        ImageView website = (ImageView)findViewById(R.id.www);
        ImageView pdf = (ImageView)findViewById(R.id.pdf);
        ImageView phone = (ImageView)findViewById(R.id.phone);
        ImageView location = (ImageView)findViewById(R.id.location);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website= new Intent();
                website.setAction(Intent.ACTION_VIEW);
                website.addCategory(Intent.CATEGORY_BROWSABLE);
                website.setData(Uri.parse("http://www.robotix.in/event/poles-apart/"));
                startActivity(website);
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website= new Intent();
                website.setAction(Intent.ACTION_VIEW);
                website.addCategory(Intent.CATEGORY_BROWSABLE);
                website.setData(Uri.parse("http://www.robotix.in/assets/event/poles-apart/poles-apart.pdf"));
                startActivity(website);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.event_contact_dialog);
                dialog.setTitle("Contact Details");

                TextView[] contact_nos = new TextView[mConfig.polesapartNames.size()];
                TextView[] contact_names = new TextView[mConfig.polesapartNames.size()];
                Button[] callButtons = new Button[mConfig.polesapartNames.size()];
                for(int i = 0; i < mConfig.polesapartNames.size(); i++) {
                    String head_name = mConfig.polesapartNames.get(i);
                    String head_number = "";
                    String head_full_name = "";
                    try{
                        JSONObject jObject = new JSONObject(mConfig.contactDetails.get(head_name));
                        head_full_name = jObject.getString("name");
                        head_number = jObject.getString("phone");
                        //Log.w("myApp", head_facebook);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    final String head_number_f = head_number;
                    final String head_full_name_f = head_full_name;

                    callButtons[i] = (Button) dialog.findViewById(getResources().getIdentifier("contact_no_btn"+Integer.toString(i+1), "id", getPackageName()));
                    contact_nos[i] = (TextView) dialog.findViewById(getResources().getIdentifier("contact_no"+Integer.toString(i+1), "id", getPackageName()));
                    contact_names[i] = (TextView) dialog.findViewById(getResources().getIdentifier("contact_name"+Integer.toString(i+1), "id", getPackageName()));
                    contact_names[i].setText(head_full_name_f);
                    contact_nos[i].setText(head_number_f);
                    callButtons[i].setVisibility(View.VISIBLE);
                    contact_nos[i].setVisibility(View.VISIBLE);
                    contact_names[i].setVisibility(View.VISIBLE);
                    callButtons[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+head_number_f));
                            startActivity(callIntent);
                        }
                    });
                    dialog.show();
                }
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pushnot = new Intent("in.robotix.robotixapp.MAPS");
                startActivity(pushnot);
            }
        });
    }
}
