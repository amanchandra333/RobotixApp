package in.robotix.robotixapp;

import android.content.Context;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by lenovo on 24-Jan-17.
 */

public class Config {

    private Context mContext;
    public Dictionary<String, String> contactDetails;
    public List<String> contactUsNames;
    public List<String> bombDisposalNames;
    public List<String> bricksNames;
    public List<String> conquestNames;
    public static final String SHARED_PREF_ROBOTIX = "sp_robotix";

    public Config(Context mContext) {
        this.mContext = mContext;
        contactDetails = new Hashtable();
        contactDetails.put("Manash", "{\"name\": \"Manash Pratim Das\",\"email\": \"manash@robotix.in\",\"phone\": \"09933890509\",\"facebook\": \"https://www.facebook.com/mpdmanash?fref=ts\"}");
        contactDetails.put("Sourish", "{\"name\": \"Sourish Ghosh\",\"email\": \"sourish@robotix.in\",\"phone\": \"07980623482\",\"facebook\": \"https://www.facebook.com/Sourish69?fref=ts\"}");
        contactDetails.put("Rajat", "{\"name\": \"Rajat Chourasia\",\"email\": \"rajat@robotix.in\",\"phone\": \"07872703173\",\"facebook\": \"\"}");
        contactDetails.put("Shweta", "{\"name\": \"Shweta Gupta\",\"email\": \"shweta@robotix.in\",\"phone\": \"07872814560\",\"facebook\": \"https://www.facebook.com/shweta.gupta1196\"}");
        contactDetails.put("Vraj", "{\"name\": \"Vraj Parikh\",\"email\": \"vraj@robotix.in\",\"phone\": \"08000981472\",\"facebook\": \"https://www.facebook.com/vraj.parikh?fref=ts\"}");
        contactDetails.put("Shubhangi", "{\"name\": \"Shubhangi Bhusan\",\"email\": \"shubhangi@robotix.in\",\"phone\": \"09933909355\",\"facebook\": \"https://www.facebook.com/shubhibhushan?fref=ts\"}");
        contactDetails.put("Shashwat", "{\"name\": \"Shashwat Gupta\",\"email\": \"shashwat@robotix.in\",\"phone\": \"07278275550\",\"facebook\": \"https://www.facebook.com/shashwatg3?fref=ts\"}");
        contactDetails.put("Aaditya", "{\"name\": \"Aaditya Sanjay Boob\",\"email\": \"adityasanjay@robotix.in\",\"phone\": \"07709119333\",\"facebook\": \"https://www.facebook.com/profile.php?id=100001453733595&fref=ts\"}");
        contactDetails.put("Chowdhury", "{\"name\": \"Chowdhury Electronics\",\"email\": \"\",\"phone\": \"09434415812\",\"facebook\": \"\"}");
        contactDetails.put("Carpenter", "{\"name\": \"Umesh carpenter\",\"email\": \"\",\"phone\": \"09434415812\",\"facebook\": \"\"}");
        contactDetails.put("Accomodation", "{\"name\": \"Sidhant Agarwal\",\"email\": \"\",\"phone\": \"09933940944\",\"facebook\": \"\"}");

        contactUsNames = Arrays.asList("Shweta", "Shubhangi", "Vraj", "Shashwat", "Manash", "Sourish", "Aaditya", "Chowdhury", "Carpenter", "Accomodation");
        bombDisposalNames = Arrays.asList("Shubhangi");
        bricksNames = Arrays.asList("Vraj", "Shashwat", "Manash");
        conquestNames = Arrays.asList("Sourish", "Aaditya");
    }



}
