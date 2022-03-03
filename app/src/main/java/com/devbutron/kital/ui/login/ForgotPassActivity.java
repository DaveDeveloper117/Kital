package com.devbutron.kital.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.devbutron.kital.R;

public class ForgotPassActivity extends AppCompatActivity {
    ImageView logoImageView;
    TextView titleTextView, subtitleTextView, passinfoTextView;
    LinearLayout inputLayout;
    Button sendBtn;
    LottieAnimationView contentAnimation;
    Animation moveUp, moveDown, fadeIn, activityIn;
    ConstraintLayout frameBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        logoImageView = findViewById(R.id.logoImageView);
        titleTextView = findViewById(R.id.titleTextView);
        subtitleTextView = findViewById(R.id.subtitleTextView);
        passinfoTextView = findViewById(R.id.passinfoTextView);
        inputLayout = findViewById(R.id.inputLayout);
        sendBtn = findViewById(R.id.signinBtn);
        contentAnimation = findViewById(R.id.contentAnimation);
        frameBack = findViewById(R.id.frameBack);

        moveUp = AnimationUtils.loadAnimation(ForgotPassActivity.this, R.anim.up_move);
        moveDown = AnimationUtils.loadAnimation(ForgotPassActivity.this, R.anim.down_move);
        fadeIn = AnimationUtils.loadAnimation(ForgotPassActivity.this, R.anim.fade_in);
        activityIn = AnimationUtils.loadAnimation(ForgotPassActivity.this, R.anim.activity_in);

        logoImageView.setAnimation(moveUp);
        titleTextView.setAnimation(moveUp);
        subtitleTextView.setAnimation(moveUp);
        inputLayout.setAnimation(fadeIn);
        sendBtn.setAnimation(moveDown);
        passinfoTextView.setAnimation(moveDown);
        contentAnimation.setAnimation(fadeIn);
        frameBack.setAnimation(activityIn);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ForgotPassActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}