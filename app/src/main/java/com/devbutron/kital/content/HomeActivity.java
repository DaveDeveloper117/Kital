package com.devbutron.kital.content;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.devbutron.kital.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    FavoriteFragment favoriteFragment = new FavoriteFragment();
    CartFragment cartFragment = new CartFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    BottomNavigationView bottomNavigation;
    Toolbar searchToolbar;
    LinearLayout linearBarContainer;

    Animation popUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activty);

        searchToolbar = findViewById(R.id.searchToolbar);
        setSupportActionBar(searchToolbar);

        linearBarContainer = findViewById(R.id.linearBarContainer);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        popUp = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.pop_up);

        loadFragment(homeFragment);

        bottomNavigation.setAnimation(popUp);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.homePage:
                    searchToolbar.setVisibility(View.VISIBLE);
                    linearBarContainer.setVisibility(View.VISIBLE);
                    loadFragment(homeFragment);
                    return true;

                case R.id.favoritePage:
                    searchToolbar.setVisibility(View.GONE);
                    linearBarContainer.setVisibility(View.GONE);
                    loadFragment(favoriteFragment);
                    return true;

                case R.id.cartPage:
                    searchToolbar.setVisibility(View.GONE);
                    linearBarContainer.setVisibility(View.GONE);
                    loadFragment(cartFragment);
                    return true;

                case R.id.profilePage:
                    searchToolbar.setVisibility(View.GONE);
                    linearBarContainer.setVisibility(View.GONE);
                    loadFragment(profileFragment);
                    return true;

            }

            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.search_bar_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        int selectedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.homePage != selectedItemId) {
            setHomeItem(HomeActivity.this);
        } else {
            super.onBackPressed();
        }
    }

    public static void setHomeItem(Activity activity) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.homePage);
    }
}