package com.kuberkings.obaki.screens.chef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.databinding.ActivityChefSelectionBinding;

public class ChefSelectionActivity extends AppCompatActivity {

    ActivityChefSelectionBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding= DataBindingUtil.setContentView(this, R.layout.activity_chef_selection);
        dataBinding.btnBecomeChef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}