package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.MainActivity;
import com.kuberkings.obaki.R;
import com.kuberkings.obaki.databinding.ActivityServiceSelectionBinding;
import com.kuberkings.obaki.util.Utility;

public class ServiceSelectionActivity extends AppCompatActivity {
    ActivityServiceSelectionBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          dataBinding=    DataBindingUtil.setContentView(this, R.layout.activity_service_selection);
          dataBinding.btnSelectChef.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Utility.startActivityClass(ServiceSelectionActivity.this, MainActivity.class);

              }
          });
        dataBinding.btnChoosePlaceToEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(ServiceSelectionActivity.this, MainActivity.class);

            }
        });

    }
}