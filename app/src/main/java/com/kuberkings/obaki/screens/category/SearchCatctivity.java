package com.kuberkings.obaki.screens.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.orders.AllOrderFragment;
import com.kuberkings.obaki.screens.bottomview.orders.PastFragment;
import com.kuberkings.obaki.screens.bottomview.orders.UpcomingFragment;
import com.kuberkings.obaki.screens.bottomview.orders.ViewPagerAdapter;
import com.kuberkings.obaki.screens.category.fragment.FeaturedFragment;
import com.kuberkings.obaki.screens.category.fragment.NewestFragment;
import com.kuberkings.obaki.screens.category.fragment.PopularFragment;
import com.kuberkings.obaki.screens.category.fragment.TrendingFragment;

public class SearchCatctivity extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_catctivity);
        tabLayout=    findViewById(R.id.tabs);
        viewPager=  findViewById(R.id.viewpager);

        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(  getSupportFragmentManager());
        pagerAdapter.addFragment(new FeaturedFragment(),"Featured");
        pagerAdapter.addFragment(new FeaturedFragment(),"Popular");
        pagerAdapter.addFragment(new FeaturedFragment(),"Newest");
        pagerAdapter.addFragment(new FeaturedFragment(),"Trending");

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}