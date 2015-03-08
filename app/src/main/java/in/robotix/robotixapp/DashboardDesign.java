package in.robotix.robotixapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class DashboardDesign extends Activity {
    
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.dashboard_layout);



//           Parse.initialize(this, "PuIzoC7eXz49viafhT3DCYqUxrLhqjPeBQjaGd6e", "sqhfmCLtI01fdiSDmmPmYdyCWlI48OFc4GIiQ2Aa");
//           ParseUser.enableAutomaticUser();
//           ParseACL defaultACL = new ParseACL();
//           defaultACL.setPublicReadAccess(true);
//
//           ParseACL.setDefaultACL(defaultACL, true);



       
    // Dashboard News feed button
       Button notice = (Button) findViewById(R.id.notice);
        
       // Dashboard Friends button
       Button events = (Button) findViewById(R.id.events);
        
       // Dashboard Messages button
       Button aboutus = (Button) findViewById(R.id.aboutus);
        
       // Dashboard Places button
       Button faqs = (Button) findViewById(R.id.faqs);
        
       // Dashboard Events button
       Button map = (Button) findViewById(R.id.map);
        
       // Dashboard Photos button
       Button contactus = (Button) findViewById(R.id.contactus);
       
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
//       home.setOnClickListener(new View.OnClickListener() {
//           
//           @Override
//           public void onClick(View view) {
//        	   Intent kraig = new Intent("in.robotix.robotixapp.DBD");
//   	           startActivity(kraig);
//           }
//       });
//       
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
       
       // Listening to News Feed button click
       notice.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   Intent pushnot = new Intent("in.robotix.robotixapp.NOTI");
   	           startActivity(pushnot);		
           }
       });
        
      // Listening Friends button click
       events.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   Intent kraig = new Intent("in.robotix.robotixapp.EVENTSHula");
   	           startActivity(kraig);
           }
       });
        
       // Listening Messages button click
       aboutus.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent dreamabot = new Intent("in.robotix.robotixapp.ABOUTUS");
   	        startActivity(dreamabot);
           }
       });
        
       // Listening to Places button click
       faqs.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent workshops= new Intent("in.robotix.robotixapp.FAQS");
   	        startActivity(workshops);
           }
       });
        
       // Listening to Events button click
       map.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent map = new Intent("in.robotix.robotixapp.GMAP");
   	        startActivity(map);
           }
       });
        
       // Listening to Photos button click
       contactus.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent hello = new Intent("in.robotix.robotixapp.NUMBERSNEW");
   	        startActivity(hello);
           }
       });
       
   }
}