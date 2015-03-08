package in.robotix.robotixapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import in.robotix.robotixapp.R;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Noti extends Activity{
	
	private NotificationManager mNotificationManager;
	   private int notificationID = 100;
	   TextView myAwesomeTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifications_complete);
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
	       
	       
	       ////////////////////////////////
	       
	       mNotificationManager =   (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			mNotificationManager.cancel(notificationID);
			
			
			String FileName = "myfile.txt";
//          Commented this out
//			File yourFile = new File("myfile.txt");
//			if(!yourFile.exists()) {
//			    try {
//                    Toast toast = Toast.makeText(this, "notnd", Toast.LENGTH_LONG);
//                    toast.show();
//					yourFile.createNewFile();
//
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}

			//Read File
			String collected  = "";
			FileInputStream fis = null;

			try {
				fis = openFileInput(FileName);
				byte[] dataArray = new byte[fis.available()];
				while (fis.read(dataArray) != -1)
				{
					collected = new String(dataArray);
				}
				
				fis.close();
				//Toast toast = Toast.makeText(this, collected, Toast.LENGTH_LONG);
				//toast.show();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				Toast toast = Toast.makeText(this, "No notifications to display", Toast.LENGTH_SHORT);
				toast.show();
                return;
				//e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//Toast toast = Toast.makeText(this, "notnd", Toast.LENGTH_LONG);
				//toast.show();
				e.printStackTrace();
			}
			
			//Toast toast = Toast.makeText(this, collected, Toast.LENGTH_LONG);
			//toast.show();

			if(collected.length() != 0)
			{
				
			String[] countryArray = collected.split("~");	
				
				
				ArrayAdapter adapter = new ArrayAdapter<String>(this, 
					      R.layout.activity_listview, countryArray);
					      
					      ListView listView = (ListView) findViewById(R.id.country_list);
					      listView.setAdapter(adapter);
			}
			
	
	       ///////////////////////////////////
	       
	}
	
	public void onClick(View v){

	    if(v.getId() == R.id.button_cnf_noti){
	    	Intent events = new Intent("in.robotix.robotixapp.EVENTS");
	           startActivity(events);	

	    }

	}
}
