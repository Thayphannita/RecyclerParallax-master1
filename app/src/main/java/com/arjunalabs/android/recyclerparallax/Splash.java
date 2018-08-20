package com.arjunalabs.android.recyclerparallax;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    //Duration for link to second activity
    private static int SESSION_AUTO= 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView)findViewById(R.id.image_splash);
        //Animation duration
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.setAnimation(animation);

        //Code intent use for link activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SESSION_AUTO);
    }
}
