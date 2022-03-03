package com.devbutron.kital.ui.login;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.devbutron.kital.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    ImageView logoImageView;
    TextView welcomeTextView, loginTextView, forgotTextView, orTextView, signupTextView;
    LinearLayout inputLayout;
    Button loginBtn;
    FloatingActionButton facebookFab, googleFab, appleFab;
    Animation moveUp, moveDown, moveRight, moveLeft, fadeIn, activityIn;
    ConstraintLayout frameBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logoImageView = findViewById(R.id.logoImageView);
        welcomeTextView = findViewById(R.id.titleTextView);
        loginTextView = findViewById(R.id.subtitleTextView);
        forgotTextView = findViewById(R.id.forgotTextView);
        orTextView = findViewById(R.id.orTextView);
        signupTextView = findViewById(R.id.signupTextView);
        inputLayout = findViewById(R.id.inputLayout);
        loginBtn = findViewById(R.id.signinBtn);
        facebookFab = findViewById(R.id.facebookFab);
        googleFab = findViewById(R.id.googleFab);
        appleFab = findViewById(R.id.appleFab);
        frameBack = findViewById(R.id.frameBack);

        moveUp = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.up_move);
        moveDown = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.down_move);
        moveRight = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.right_move);
        moveLeft = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.left_move);
        fadeIn = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade_in);
        activityIn = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.activity_in);

        logoImageView.setAnimation(moveUp);
        welcomeTextView.setAnimation(moveUp);
        loginTextView.setAnimation(moveUp);
        inputLayout.setAnimation(fadeIn);
        forgotTextView.setAnimation(moveRight);
        loginBtn.setAnimation(moveDown);
        orTextView.setAnimation(moveDown);
        facebookFab.setAnimation(moveLeft);
        googleFab.setAnimation(moveDown);
        appleFab.setAnimation(moveRight);
        signupTextView.setAnimation(moveDown);
        frameBack.setAnimation(activityIn);

        forgotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
                startActivity(intent);
                finish();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SlideActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}