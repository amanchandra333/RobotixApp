package in.robotix.robotixapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import in.robotix.robotixapp.firebase.GoogleSignInActivity;
import in.robotix.robotixapp.opener.OpenerMain;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}