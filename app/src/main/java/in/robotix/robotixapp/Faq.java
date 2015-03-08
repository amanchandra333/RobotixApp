package in.robotix.robotixapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Faq extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faq_complete);
		
		ImageView fb = (ImageView) findViewById(R.id.fb);
	       ImageView home = (ImageView) findViewById(R.id.home);
	       ImageView yt = (ImageView) findViewById(R.id.yt);
	       ImageView wp = (ImageView) findViewById(R.id.wp);
	       ImageView tw = (ImageView) findViewById(R.id.tw);
	       
	       ImageView web= (ImageView) findViewById(R.id.web);
	       
	       	web.setOnClickListener(new View.OnClickListener() {
	           
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
	       
	       home.setOnClickListener(new View.OnClickListener() {
	           
	           @Override
	           public void onClick(View view) {
	        	   Intent kraig = new Intent("in.robotix.robotixapp.DBD");
	   	           startActivity(kraig);
	           }
	       });
	       
	       fb.setOnClickListener(new View.OnClickListener() {
	           
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
	       
	       yt.setOnClickListener(new View.OnClickListener() {
	           
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
	       
	       wp.setOnClickListener(new View.OnClickListener() {
	           
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
	       
	       tw.setOnClickListener(new View.OnClickListener() {
	           
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
	}

}
