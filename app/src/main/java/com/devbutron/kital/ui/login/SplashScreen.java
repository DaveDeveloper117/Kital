package com.devbutron.kital.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.devbutron.kital.R;

public class SplashScreen extends AppCompatActivity {

    LottieAnimationView contentAnimation;
    TextView titleText, welcomeText;
    Animation fadeIn, moveUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentAnimation = findViewById(R.id.contentAnimation);
        titleText = findViewById(R.id.titleText);
        welcomeText = findViewById(R.id.welcomeText);

        moveUp = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.up_move);
        fadeIn = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_in);

        contentAnimation.setAnimation(fadeIn);
        titleText.setAnimation(moveUp);
        welcomeText.setAnimation(moveUp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
                contentAnimation.loop(false);
            }
        }, 2000);

    }
}