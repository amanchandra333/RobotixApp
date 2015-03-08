package in.robotix.robotixapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EventsDesign extends Activity {
    
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.events_complete);
        
       Button event1 = (Button) findViewById(R.id.event1);

       Button event2 = (Button) findViewById(R.id.event2);
        
       Button event3 = (Button) findViewById(R.id.event3);
        
       Button event4 = (Button) findViewById(R.id.event4);

       Button event5 = (Button) findViewById(R.id.event5);

       Button event6 = (Button) findViewById(R.id.event6);
       
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
        
      event1.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent inspiralon = new Intent("in.robotix.robotixapp.CASCADE");
   	        startActivity(inspiralon);		
           }
       });
        
      // Listening Friends button click
      event2.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	   Intent inspiralon = new Intent("in.robotix.robotixapp.SKYFALL");
      	        startActivity(inspiralon);	
           }
       });
        
       // Listening Messages button click
      event3.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	   Intent inspiralon = new Intent("in.robotix.robotixapp.MINEFIELD");
      	        startActivity(inspiralon);	
           }
       });
        
       // Listening to Places button click
       event4.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent workshops= new Intent("in.robotix.robotixapp.STEPUP");
   	        startActivity(workshops);
           }
       });
        
       // Listening to Events button click
       event5.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent faq = new Intent("in.robotix.robotixapp.AUGHIT");
   	        startActivity(faq);
           }
       });
        
       // Listening to Photos button click
       event6.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
               // Launching News Feed Screen
        	Intent contactus = new Intent("in.robotix.robotixapp.SUDOCODE");
   	        startActivity(contactus);
           }
       });
   }
}