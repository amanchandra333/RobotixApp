package in.robotix.robotixapp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CustomNotificationReceiver extends BroadcastReceiver {

	private NotificationManager mNotificationManager;
	   private int notificationID = 100;

String text_to_write = "";

String alert; // This is the message string that send from push console

@Override
public void onReceive(Context context, Intent intent) {
	final int NOTIFICATION_ID = 1;   
	

//Get JSON data and put them into variables
try {

JSONObject json = new JSONObject(intent.getExtras().getString(
"com.parse.Data")); 

alert = json.getString("alert").toString();

String channel = json.getString("rbtxchannel").toString();

    //Toast toast = Toast.makeText(context, alert, Toast.LENGTH_LONG);
    //toast.show();

//Read File .... doing
String txt_events  = null;
FileInputStream fis1 = null;


//    File yourFile = new File("events.txt");
//    if(!yourFile.exists()) {
//        try {
//            yourFile.createNewFile();
//            FileOutputStream fos1;
//            try {
//                fos1 = context.openFileOutput("events.txt",Context.MODE_PRIVATE);
//                String write = "aughit~stepup~sudocode~skyfall~cascade~minefield~";
//
//                fos1.write(write.getBytes());
//                fos1.close();
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

try {
	fis1 = context.openFileInput("events.txt");
	byte[] dataArray = new byte[fis1.available()];
	while (fis1.read(dataArray) != -1)
	{
		txt_events = new String(dataArray);
	}
    fis1.close();

} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
    FileOutputStream fos1;
    try {
        fos1 = context.openFileOutput("events.txt",Context.MODE_PRIVATE);
        String write = "general~aughit~stepup~sudocode~skyfall~cascade~minefield~";

        fos1.write(write.getBytes());
        fos1.close();
    } catch (FileNotFoundException f) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException f) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    txt_events = "general~aughit~stepup~sudocode~skyfall~cascade~minefield~";
	//e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

finally{

}

txt_events = txt_events.substring(0, txt_events.length()-1);
String[] events = txt_events.split("~");
//Toast toast1 = Toast.makeText(context, txt_events, Toast.LENGTH_LONG);
//toast1.show();

if(stringContainsItemFromList(channel, events))
{
	NotificationCompat.Builder  mBuilder =
			new NotificationCompat.Builder(context);
			mBuilder.setContentTitle("Robotix 2015");
			mBuilder.setContentText(alert);
			mBuilder.setTicker(alert);
			mBuilder.setSmallIcon(R.drawable.ic_launcher);
			Intent intentn = new Intent(context,Noti.class);
			PendingIntent pi = PendingIntent.getActivity(context, 0, intentn, PendingIntent.FLAG_CANCEL_CURRENT);
			mBuilder.setContentIntent(pi);
			mBuilder.setDefaults(Notification.DEFAULT_ALL);
			mNotificationManager =   (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			mNotificationManager.notify(notificationID, mBuilder.build());

//			//check if file exists

    String FileName = "myfile.txt";

//    File yourFile1 = new File("myfile.txt");
//    if(!yourFile1.exists()) {
//        try {
//            yourFile1.createNewFile();
//            FileOutputStream fos3;
//            try {
//                fos3 = context.openFileOutput("myfile.txt",Context.MODE_PRIVATE);
//                String write = "";
//                fos3.write(write.getBytes());
//                fos3.close();
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    //Read File ... doing
    String collected  = "";
    FileInputStream fis;

    text_to_write = alert;

    try {
        fis = context.openFileInput(FileName);
        byte[] dataArray = new byte[fis.available()];
        while (fis.read(dataArray) != -1)
        {
            collected = new String(dataArray);
        }
        text_to_write = alert + "~" + collected;
        fis.close();


    } catch (FileNotFoundException e) {

        // TODO Auto-generated catch block

        FileOutputStream fos3;
        try {
            fos3 = context.openFileOutput("myfile.txt",Context.MODE_PRIVATE);
            String write = "";
            fos3.write(write.getBytes());
            fos3.close();
        } catch (FileNotFoundException f) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException f) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //collected = "";

        //e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    finally{

    }


    FileOutputStream fos;
    try {
        fos = context.openFileOutput(FileName,Context.MODE_PRIVATE);
        String write = text_to_write;

        fos.write(write.getBytes());
        fos.close();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        Toast toast2 = Toast.makeText(context, "Not found", Toast.LENGTH_SHORT);
        toast2.show();
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}






} catch (JSONException e) {

}


}

public static boolean stringContainsItemFromList(String inputString, String[] items)
{
    for(int i =0; i < items.length; i++)
    {
        if(inputString.contains(items[i]))
        {
            return true;
        }
    }
    return false;
}



}

