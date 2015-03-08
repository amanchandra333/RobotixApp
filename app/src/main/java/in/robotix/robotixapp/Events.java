package in.robotix.robotixapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import in.robotix.robotixapp.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class Events extends Activity{
	
	String events_selected = "";
    View v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_sel_complete);
		ImageView fb = (ImageView) findViewById(R.id.fb);
	    ImageView home = (ImageView) findViewById(R.id.home);
	    ImageView yt = (ImageView) findViewById(R.id.yt);
	    ImageView wp = (ImageView) findViewById(R.id.wp);
	    ImageView tw = (ImageView) findViewById(R.id.tw);
	    ImageView web= (ImageView) findViewById(R.id.web);

//        String buttonID = "ck_sudocode";
//        int resID = getResources().getIdentifier(buttonID, "id", "in.robotix.robotixapp");
//        CheckBox checkBox1 = (CheckBox)v.findViewById(R.id.ck_sudocode);
//        checkBox1.setChecked(true);


	    
	  //Read File .... doing

//        File yourFile = new File("events.txt");
//        if(!yourFile.exists()) {
//            try {
//                yourFile.createNewFile();
//                FileOutputStream fos1;
//                try {
//                    fos1 = openFileOutput("events.txt",Context.MODE_PRIVATE);
//                    String write = "aughit~stepup~sudocode~skyfall~cascade~minefield~";
//
//                    fos1.write(write.getBytes());
//                    fos1.close();
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
	    String txt_events  = null;
	    FileInputStream fis1;

	    try {
	    	fis1 = openFileInput("events.txt");
	    	byte[] dataArray = new byte[fis1.available()];
	    	while (fis1.read(dataArray) != -1)
	    	{
	    		txt_events = new String(dataArray);
	    	}
	    	//Toast toast = Toast.makeText(context, collected, Toast.LENGTH_LONG);
	    	//toast.show();
            fis1.close();

	    } catch (FileNotFoundException e) {
            //Toast toast = Toast.makeText(this, "file not found", Toast.LENGTH_LONG);
            //toast.show();
            FileOutputStream fos1;
                try {
                    fos1 = openFileOutput("events.txt",Context.MODE_PRIVATE);
                    String write = "general~aughit~stepup~sudocode~skyfall~cascade~minefield~";

                    fos1.write(write.getBytes());
                    fos1.close();
                    txt_events = "general~aughit~stepup~sudocode~skyfall~cascade~minefield~";
                } catch (FileNotFoundException f) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException f) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
	    	// TODO Auto-generated catch block
	    	//e.printStackTrace();
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }

	    finally{

	    }

	    txt_events = txt_events.substring(0, txt_events.length()-1);
	    String[] events = txt_events.split("~");


	    for(int i = 0; i< events.length;i++)
	    {
	    	String id_text = "ck_" + events[i];

            int resID = getResources().getIdentifier(id_text, "id", getPackageName());
            CheckBox cb = (CheckBox) findViewById(resID);
            cb.setChecked(true);


	    }
	       
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
	
	public void onClick(View v){

        CheckBox checkBox;
        events_selected="";

	    if(v.getId() == R.id.btn_save){
	    	checkBox = (CheckBox) findViewById(R.id.ck_aughit);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "aughit~"; 
	        }
	        
	        checkBox = (CheckBox) findViewById(R.id.ck_minefield);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "minefield~"; 
	        }
	        
	        checkBox = (CheckBox) findViewById(R.id.ck_cascade);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "cascade~"; 
	        }
	        
	        checkBox = (CheckBox) findViewById(R.id.ck_skyfall);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "skyfall~"; 
	        }
	        
	        checkBox = (CheckBox) findViewById(R.id.ck_stepup);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "stepup~"; 
	        }
	        
	        checkBox = (CheckBox) findViewById(R.id.ck_sudocode);
	        if(checkBox.isChecked()){
	        	events_selected = events_selected + "sudocode~";
	        }
	        
	        FileOutputStream fos;
			try {
				fos = openFileOutput("events.txt",Context.MODE_PRIVATE);
				
				
				fos.write(events_selected.getBytes());
				fos.close();
				Toast toast = Toast.makeText(this, "Your Selections are saved", Toast.LENGTH_LONG);
				toast.show();

				Intent events = new Intent("in.robotix.robotixapp.NOTI");
		           startActivity(events);	
				//finish();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	}
}
