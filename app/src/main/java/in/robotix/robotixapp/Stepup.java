package in.robotix.robotixapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Stepup extends Activity{

	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stepup_complete);
		ImageView website= (ImageView)findViewById(R.id.www);
		ImageView pdfl= (ImageView)findViewById(R.id.pdf);
		ImageView phonel= (ImageView)findViewById(R.id.phone);
		ImageView locationl = (ImageView)findViewById(R.id.location);

		ImageView fb = (ImageView) findViewById(R.id.fb);
	       ImageView home = (ImageView) findViewById(R.id.home);
	       ImageView yt = (ImageView) findViewById(R.id.yt);
	       ImageView wp = (ImageView) findViewById(R.id.wp);
	       ImageView tw = (ImageView) findViewById(R.id.tw);
	       ImageView web= (ImageView) findViewById(R.id.web);

	       	web.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent website= new Intent();
	   	        website.setAction(Intent.ACTION_VIEW);
	   	        website.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        website.setData(Uri.parse("http://robotix.in/"));
	   	        startActivity(website);
	           }
	       });

	       home.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	        	   Intent kraig = new Intent("in.robotix.robotixapp.DBD");
	   	           startActivity(kraig);
	           }
	       });

	       fb.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent updates = new Intent();
	   	        updates.setAction(Intent.ACTION_VIEW);
	   	        updates.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        updates.setData(Uri.parse("https://www.facebook.com/robotixiitkgp"));
	   	        startActivity(updates);
	           }
	       });

	       yt.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent updates = new Intent();
	   	        updates.setAction(Intent.ACTION_VIEW);
	   	        updates.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        updates.setData(Uri.parse("http://www.youtube.com/robotixiitkgp"));
	   	        startActivity(updates);
	           }
	       });

	       wp.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent updates = new Intent();
	   	        updates.setAction(Intent.ACTION_VIEW);
	   	        updates.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        updates.setData(Uri.parse("http://blog.robotix.in/"));
	   	        startActivity(updates);
	           }
	       });

	       tw.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent updates = new Intent();
	   	        updates.setAction(Intent.ACTION_VIEW);
	   	        updates.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        updates.setData(Uri.parse("https://twitter.com/robotixiitkgp"));
	   	        startActivity(updates);
	           }
	       });

		website.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent website= new Intent();
	   	        website.setAction(Intent.ACTION_VIEW);
	   	        website.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        website.setData(Uri.parse("http://www.robotix.in/events/event/stepup"));
	   	        startActivity(website);
	           }
	       });
		pdfl.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
	               // Launching News Feed Screen
	        	Intent website= new Intent();
	   	        website.setAction(Intent.ACTION_VIEW);
	   	        website.addCategory(Intent.CATEGORY_BROWSABLE);
	   	        website.setData(Uri.parse("http://robotix.in/PDF/finalevent_stepup.pdf"));
	   	        startActivity(website);
	           }
	       });
		phonel.setOnClickListener(new OnClickListener() {

	           @Override
	           public void onClick(View view) {
                   // Launching News Feed Screen
                   final Dialog dialog = new Dialog(context,R.style.ContactDialog);
                   dialog.setContentView(R.layout.event_contact_dialog);
                   //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                   dialog.setTitle("Contact Details");

                   // set the custom dialog components - text, image and button
                   Button dialogButton1 = (Button) dialog.findViewById(R.id.contact_no_btn1);
                   Button dialogButton2 = (Button) dialog.findViewById(R.id.contact_no_btn2);
                   Button dialogButton3 = (Button) dialog.findViewById(R.id.contact_no_btn3);
                   TextView contact_no1 = (TextView) dialog.findViewById(R.id.contact_no1);
                   TextView contact_no2 = (TextView) dialog.findViewById(R.id.contact_no2);
                   TextView contact_no3 = (TextView) dialog.findViewById(R.id.contact_no3);
                   TextView contact_name1 = (TextView)dialog.findViewById(R.id.contact_name1);
                   TextView contact_name2 = (TextView)dialog.findViewById(R.id.contact_name2);
                   TextView contact_name3 = (TextView)dialog.findViewById(R.id.contact_name3);

                   contact_name1.setText("Ruchita Kachhap");
                   contact_no1.setText("+91-9126149118");
                   contact_name2.setText("Harsheel Singh Soin");
                   contact_no2.setText("+91-8967762824");
                   contact_name3.setText("Ashutosh Baheti");
                   contact_no3.setText("+91-8159875992");
//
//                   contact_name2.setVisibility(View.GONE);
//                   contact_no2.setVisibility(View.GONE);
//                   dialogButton2.setVisibility(View.GONE);

//                   contact_name3.setVisibility(View.GONE);
//                   contact_no3.setVisibility(View.GONE);
//                   dialogButton3.setVisibility(View.GONE);

                   // if button is clicked, close the custom dialog
                   dialogButton1.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           dialog.dismiss();
                           Intent callIntent = new Intent(Intent.ACTION_CALL);
                           callIntent.setData(Uri.parse("tel:09126149118"));
                           startActivity(callIntent);
                       }
                   });

                   dialogButton2.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           dialog.dismiss();
                           Intent callIntent = new Intent(Intent.ACTION_CALL);
                           callIntent.setData(Uri.parse("tel:08967762824"));
                           startActivity(callIntent);
                       }
                   });

                   dialogButton3.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           dialog.dismiss();
                           Intent callIntent = new Intent(Intent.ACTION_CALL);
                           callIntent.setData(Uri.parse("tel:08159875992"));
                           startActivity(callIntent);
                       }
                   });


                   dialog.show();
	           }
	       });
		locationl.setOnClickListener(new OnClickListener() {
	           @Override
	           public void onClick(View view) {
	        	   Intent pushnot = new Intent("in.robotix.robotixapp.GMAP");
	   	           startActivity(pushnot);		
	           }
	       });
}
}
