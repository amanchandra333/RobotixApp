package in.robotix.robotixapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.robotix.robotixapp.opener.OpenerMain;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, OpenerMain.class);
        startActivity(intent);
        finish();
    }
}