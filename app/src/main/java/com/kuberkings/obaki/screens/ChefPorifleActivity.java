package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.adapter.HomeChefAdapter;
import com.kuberkings.obaki.databinding.ActivityChefPorifleBinding;
import com.kuberkings.obaki.util.ClickListner;
import com.kuberkings.obaki.util.Utility;

public class ChefPorifleActivity extends AppCompatActivity {
    ActivityChefPorifleBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding=    DataBindingUtil.setContentView(this, R.layout.activity_chef_porifle);
        dataBinding.rvRecyclerviewChefProfile.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        dataBinding.rvRecyclerviewChefProfile.setAdapter(new HomeChefAdapter(new String[10], new   ClickListner() {
            @Override
            public void onclickItem(int position) {

            }
        }));

        findViewById(R.id.btnBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dataBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivity(ChefPorifleActivity.this,ChefCheckoutActivity.class);
            }
        });
    }
}