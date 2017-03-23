package in.robotix.robotixapp.firebase;

/**
 * Created by lenovo on 25-Jan-17.
 */

public class FirebaseConfig {
    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";
    public static final String TOPIC_BOMBDISPOSAL = "bombdisposal";
    public static final String TOPIC_CONQUEST = "conquest";
    public static final String TOPIC_BRICKS = "bricks";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    public static final String REG_SERVER = "http://manashpratim.in/robotix.php";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "sp_firebase";
}
