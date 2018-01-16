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
    public List<String> polesapartNames;
    public List<String> staxNames;
    public List<String> fortressNames;
    public static final String SHARED_PREF_ROBOTIX = "sp_robotix";

    public Config(Context mContext) {
        this.mContext = mContext;
        contactDetails = new Hashtable();
        contactDetails.put("Aman", "{\"name\": \"Aman Chandra\",\"email\": \"aman.chandra@robotix.in\",\"phone\": \"08987272929\",\"facebook\": \"https://www.facebook.com/amanchandra333\"}");
        contactDetails.put("Shivang", "{\"name\": \"Shivang Agarwal\",\"email\": \"shivang.agarwal@robotix.in\",\"phone\": \"9455538734\",\"facebook\": \"https://www.facebook.com/crazyshivang\"}");
        contactDetails.put("Rohan", "{\"name\": \"Rohan Sitaniya\",\"email\": \"rohan.sitaniya@robotix.in\",\"phone\": \"07872703173\",\"facebook\": \"\"}");
        contactDetails.put("Stuti", "{\"name\": \"Stuti Modi\",\"email\": \"stuti.modi@robotix.in\",\"phone\": \"09874590222\",\"facebook\": \"https://www.facebook.com/StutiModi09\"}");
        contactDetails.put("Aditi", "{\"name\": \"Aditi Kambli\",\"email\": \"aditi.kambli@robotix.in\",\"phone\": \" 9932368081\",\"facebook\": \"aditi1997kambli@gmail.com\"}");
        contactDetails.put("Swadha", "{\"name\": \"Swadha\",\"email\": \"swadha.gupta@robotix.in\",\"phone\": \"9425563726\",\"facebook\": \"https://www.facebook.com/swadha.gupta.77736\"}");
        contactDetails.put("Vivek", "{\"name\": \"Vivek \",\"email\": \"vivek.mudgal@robotix.in\",\"phone\": \"7407777007\",\"facebook\": \"https://www.facebook.com/vivekmudgal10\"}");
        contactDetails.put("Amit", "{\"name\": \"Amit Pathak\",\"email\": \"amit.pathak@robotix.in\",\"phone\": \"9431888031\",\"facebook\": \"https://www.facebook.com/amitpathak.iitkgp\"}");
        contactDetails.put("Ayush", "{\"name\": \"Ayush Patnaik\",\"email\": \"ayush.patnaik@robotix.in\",\"phone\": \"8436932111\",\"facebook\": \"https://www.facebook.com/ayushpat7\"}");
        contactDetails.put("Chowdhury", "{\"name\": \"Chowdhury Electronics\",\"email\": \"\",\"phone\": \"09434415812\",\"facebook\": \"\"}");
        contactDetails.put("Carpenter", "{\"name\": \"Umesh carpenter\",\"email\": \"\",\"phone\": \"09434415812\",\"facebook\": \"\"}");
        contactDetails.put("Accomodation", "{\"name\": \"Sidhant Agarwal\",\"email\": \"\",\"phone\": \"09933940944\",\"facebook\": \"\"}");

        contactUsNames = Arrays.asList("Aman", "Shivang", "Rohan", "Stuti", "Aditi", "Swadha", "Vivek", "Chowdhury", "Carpenter", "Accomodation");
        polesapartNames = Arrays.asList("Amit", "Rohan");
        staxNames = Arrays.asList("Aman", "Vivek", "Shivang");
        fortressNames = Arrays.asList("Swadha");
    }



}
