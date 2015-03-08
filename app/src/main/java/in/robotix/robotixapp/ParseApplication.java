package in.robotix.robotixapp;
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.PushService;

public class ParseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "PuIzoC7eXz49viafhT3DCYqUxrLhqjPeBQjaGd6e", "sqhfmCLtI01fdiSDmmPmYdyCWlI48OFc4GIiQ2Aa");

        Parse.initialize(this, "PuIzoC7eXz49viafhT3DCYqUxrLhqjPeBQjaGd6e", "sqhfmCLtI01fdiSDmmPmYdyCWlI48OFc4GIiQ2Aa");
        PushService.setDefaultPushCallback(this,DashboardDesign.class);
//        ParseUser.enableAutomaticUser();
//        ParseACL defaultACL = new ParseACL();
//        defaultACL.setPublicReadAccess(true);
//        ParseACL.setDefaultACL(defaultACL, true);
    }
}
