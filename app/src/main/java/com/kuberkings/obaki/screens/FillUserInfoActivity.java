package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.Utility;

public class FillUserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_user_info);
        findViewById(R.id.btn_fill_user_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(FillUserInfoActivity.this, OnBoardingActivity.class);
                finish();
            }
        });
    }
}