package com.muryno.listedkey;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.muryno.listedkey.AuthAtivities.AuthActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class StartUpScreen extends AppCompatActivity {

    private ImageView logoR;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);
        printhashkey();
        i = new Intent(StartUpScreen.this,AuthActivity.class);

    /*    logoR = (ImageView)findViewById(R.id.logo);
        // logoR.startAnimation(animation);
        logoR.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)logoR.getBackground()).start();
            }
        });*/

        Thread thread = new Thread( ){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(i);


                }
            }
        };thread.start();
    }
        public void printhashkey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.muryno.listedkey",
                    PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
