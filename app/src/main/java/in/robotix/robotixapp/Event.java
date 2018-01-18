package in.robotix.robotixapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONObject;

/**
 * Created by lenovo on 24-Jan-17.
 */

public class Event extends NavigationDrawer{
    final Context context = this;
    Config mConfig;
    private String mUrl, mtitle, mPdf;
    private int mID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                mPdf = null;
                mUrl= null;
                mtitle = null;
            } else {
                mID= extras.getInt("ID");
                mUrl= extras.getString("Url");
                mPdf= extras.getString("PDF");
                mtitle= extras.getString("Title");
            }
        } else {
            mID= (Integer) savedInstanceState.getSerializable("ID");
            mUrl= (String) savedInstanceState.getSerializable("Url");
            mPdf= (String) savedInstanceState.getSerializable("PDF");
            mtitle= (String) savedInstanceState.getSerializable("Title");
        }

        setContentView(R.layout.activity_event);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_event);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_event);
        collapsingToolbar.setTitle(mtitle);

        TextView category = (TextView)findViewById(R.id.textView3);
        TextView ps = (TextView)findViewById(R.id.textView2);
        TextView usp = (TextView)findViewById(R.id.textView1);
        ImageView image = (ImageView)findViewById(R.id.event_pic);

        if(mID==0){
            category.setText("Category of event: AUTONOMOUS");
            ps.setText("To build a robot which can rearrange blocks of different colours from a stack in a pattern by identifying the colours simultaneously moving across the stacks using line following.");
            usp.setText("• Autonomous Traversal (Line Following)\n" +
                    "                \\n• Colour Identification\n" +
                    "                \\n• Sorting Algorithm");
            image.setImageResource(R.drawable.stax);
        }
        else if(mID==1){
            category.setText("Category of event: MANUAL");
            ps.setText("• Changing interaxial distance.\n" +
                    "                \\n• Gripping and lifting mechanism.\n" +
                    "                \\n• Placing blocks in their respective places.");
            image.setImageResource(R.drawable.polesapart);
        }
        else{
            category.setText("Category of event: COMPUTER VISION");
            ps.setText("Build an image processing robot that can recognise useful patterns by pattern recognition while avoiding other obstacles. The video feed of the arena will be given by an overhead camera.");
            usp.setText("• Template matching\n" +
                    "                \\n• Pattern Recognition\n" +
                    "                \\n• Image segmentation\n" +
                    "                \\n• Autonomous traversal");
            image.setImageResource(R.drawable.fortress);
        }

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
                website.setData(Uri.parse(mUrl));
                startActivity(website);
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent website= new Intent();
                website.setAction(Intent.ACTION_VIEW);
                website.addCategory(Intent.CATEGORY_BROWSABLE);
                website.setData(Uri.parse(mPdf));
                startActivity(website);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                dialog.setContentView(R.layout.event_contact_dialog);
                dialog.setTitle("Contact Details");

                TextView[] contact_nos = new TextView[mConfig.eventNames.get(mID).size()];
                TextView[] contact_names = new TextView[mConfig.eventNames.get(mID).size()];
                Button[] callButtons = new Button[mConfig.eventNames.get(mID).size()];
                for(int i = 0; i < mConfig.eventNames.get(mID).size(); i++) {
                    String head_name = mConfig.eventNames.get(mID).get(i);
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
    @Override
    public void onBackPressed() {
        Intent pushnot = new Intent("in.robotix.robotixapp.HOME");
        startActivity(pushnot);
        finish();
    }
}
