package com.cyberinov8.camerafilterapp;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cyberinov8.camerafilterapp.utils.FSPA;

public class LoginActivity extends AppCompatActivity {
    private FSPA fspa;
    private ViewPager viewPager;
    private Button buttonSignIn;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fspa = new FSPA(getSupportFragmentManager(), 2);
        viewPager = findViewById(R.id.viewPager);
        buttonSignIn = findViewById(R.id.sign_in);
        buttonSignUp = findViewById(R.id.sign_up);
        viewPager.setAdapter(fspa);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    buttonSignIn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    buttonSignIn.setTextColor(getResources().getColor(R.color.white));
                    buttonSignUp.setBackgroundColor(getResources().getColor(R.color.disable_color));
                    buttonSignUp.setTextColor(getResources().getColor(R.color.colorAccent));
                } else if (position == 1) {
                    buttonSignIn.setBackgroundColor(getResources().getColor(R.color.disable_color));
                    buttonSignIn.setTextColor(getResources().getColor(R.color.colorAccent));
                    buttonSignUp.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    buttonSignUp.setTextColor(getResources().getColor(R.color.white));

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }
}
