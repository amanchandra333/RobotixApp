package in.robotix.robotixapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends Activity{
	
	ImageView gear;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

//        Parse.initialize(this, "xsALgT8rZDdf7M7jOerybnD49VEokz2cTrKy1QzG", "XdSLdnBSB3mjrzvPIhqhpucQaJtzsy0TwMXYhAzB");
//        ParseUser.enableAutomaticUser();
//        ParseACL defaultACL = new ParseACL();
//        // If you would like all objects to be private by default, remove this line.
//        defaultACL.setPublicReadAccess(true);
//        ParseACL.setDefaultACL(defaultACL, true);
        //ParseAnalytics.trackAppOpened(getIntent());
        ParseAnalytics.trackAppOpened(getIntent());
		
//		File yourFile = new File("events.txt");
//		if(!yourFile.exists()) {
//		    try {
//				yourFile.createNewFile();
//				FileOutputStream fos;
//				try {
//					fos = openFileOutput("events.txt",Context.MODE_PRIVATE);
//					String write = "aughit~minefield~cascade~stepup~sudocode~skyfall~";
//
//					fos.write(write.getBytes());
//					fos.close();
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

        //Parse.initialize(this, "PuIzoC7eXz49viafhT3DCYqUxrLhqjPeBQjaGd6e", "sqhfmCLtI01fdiSDmmPmYdyCWlI48OFc4GIiQ2Aa");

	    
	    //ParseAnalytics.trackAppOpened(getIntent());
		
		initialisers();				
		
		Thread timer= new Thread()
		{
			public void run()
			{
				try
				{
					sleep(3000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally{
					Intent openMenu= new Intent("in.robotix.robotixapp.DBD");
					startActivity(openMenu);
				}
			}
		};
		timer.start();
		
	}
		
	
	private void initialisers() {
		// TODO Auto-generated method stub
		gear= (ImageView)findViewById(R.id.launchgear);
	}


}


