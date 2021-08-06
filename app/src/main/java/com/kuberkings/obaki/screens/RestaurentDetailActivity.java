package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.adapter.HomeDish2Adapter;
import com.kuberkings.obaki.databinding.ActivityRestaurentDetailBinding;
import com.kuberkings.obaki.util.Utility;

public class RestaurentDetailActivity extends AppCompatActivity {


    ActivityRestaurentDetailBinding databinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent_detail);
        databinding=    DataBindingUtil.setContentView(this, R.layout.activity_restaurent_detail);

        databinding.rvRecyclerviewDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        databinding.rvRecyclerviewDetail.setAdapter(new HomeDish2Adapter(new String[10]));

        databinding.btnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        databinding.btnBookAndEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivity(RestaurentDetailActivity.this,CheckOutActivity.class);
            }
        });
    }
}