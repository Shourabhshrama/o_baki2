package com.kuberkings.obaki.screens.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.orders.AllOrderFragment;
import com.kuberkings.obaki.screens.bottomview.orders.PastFragment;
import com.kuberkings.obaki.screens.bottomview.orders.UpcomingFragment;
import com.kuberkings.obaki.screens.bottomview.orders.ViewPagerAdapter;

public class OrderActivity extends AppCompatActivity {
    TabLayout tab_layout;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tab_layout=    findViewById(R.id.tabs);
        pager=  findViewById(R.id.viewpager);
          findViewById(R.id.backImage).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  finish();
              }
          });

        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(  getSupportFragmentManager());
        pagerAdapter.addFragment(new AllOrderFragment(),"All");
        pagerAdapter.addFragment(new UpcomingFragment(),"Upcoming");
        pagerAdapter.addFragment(new PastFragment(),"Past Order");

        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tab_layout.setupWithViewPager(pager);
    }
}