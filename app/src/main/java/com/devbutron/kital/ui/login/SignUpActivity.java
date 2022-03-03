package com.devbutron.kital.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devbutron.kital.R;

public class SignUpActivity extends AppCompatActivity {
    ImageView logoImageView;
    TextView titleTextView, subtitleTextView, loginTextView;
    LinearLayout inputLayout;
    Button signinBtn;
    Animation moveUp, moveDown, fadeIn, activityIn;
    ConstraintLayout frameBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        logoImageView = findViewById(R.id.logoImageView);
        titleTextView = findViewById(R.id.titleTextView);
        subtitleTextView = findViewById(R.id.subtitleTextView);
        loginTextView = findViewById(R.id.loginTextView);
        inputLayout = findViewById(R.id.inputLayout);
        signinBtn = findViewById(R.id.signinBtn);
        frameBack = findViewById(R.id.frameBack);

        moveUp = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.up_move);
        moveDown = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.down_move);
        fadeIn = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.fade_in);
        activityIn = AnimationUtils.loadAnimation(SignUpActivity.this, R.anim.activity_in);

        logoImageView.setAnimation(moveUp);
        titleTextView.setAnimation(moveUp);
        subtitleTextView.setAnimation(moveUp);
        inputLayout.setAnimation(fadeIn);
        signinBtn.setAnimation(moveDown);
        loginTextView.setAnimation(moveDown);
        frameBack.setAnimation(activityIn);

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}