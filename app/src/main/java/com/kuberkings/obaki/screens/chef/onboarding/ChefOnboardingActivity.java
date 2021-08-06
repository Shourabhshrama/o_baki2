package com.kuberkings.obaki.screens.chef.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.CountrySelectionActivity;
import com.kuberkings.obaki.screens.OnBoardingPagerActivity;
import com.kuberkings.obaki.screens.UserSelelctionActivity;
import com.kuberkings.obaki.screens.chef.ChefSelectionActivity;
import com.kuberkings.obaki.screens.fragment.onboarding.OneFragment;
import com.kuberkings.obaki.screens.fragment.onboarding.ThreeFragment;
import com.kuberkings.obaki.screens.fragment.onboarding.TwoFragment;
import com.kuberkings.obaki.util.Utility;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class ChefOnboardingActivity extends AppCompatActivity {

    DotsIndicator dotsIndicator;
    TextView textViewSkip;
    AppCompatButton buttonNextOnBoard;
    ViewPager viewpager;
    MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_onboarding);
        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);
        textViewSkip = (TextView) findViewById(R.id.skipBtn);
        buttonNextOnBoard = (AppCompatButton) findViewById(R.id.buttonNextOnBoard);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new  MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewpager);

        buttonNextOnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index= viewpager.getCurrentItem();
                switch (index){
                    case 0 : viewpager.setCurrentItem(index+1);
                        break;
                    case 1 : viewpager.setCurrentItem(index+1);
                        buttonNextOnBoard.setText("Get Started");
                        break;
                    case 2 : {
                        Utility.startActivityClass(ChefOnboardingActivity.this, ChefSelectionActivity.class);
                        finish();


                    }
                    break;
                    default:{
                        Utility.startActivityClass(ChefOnboardingActivity.this, ChefSelectionActivity .class);
                        finish();


                    };
                }
            }
        });

        textViewSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(ChefOnboardingActivity.this, ChefSelectionActivity .class);
                finish();
            }
        });

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ChefOnboardingFragment1.newInstance("", "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return ChefOnBoardingFragment2.newInstance("1", "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return ChefOnBoardingFragment3.newInstance("2", "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}