package com.kuberkings.obaki.screens.bottomview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kuberkings.obaki.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

public class BottomNavigationActivity extends AppCompatActivity {
    ViewPager viewpager;
    ViewPagerAdapter adapter;
    int[] images = {R.drawable.demo_image_one, R.drawable.demo_image_two, R.drawable.demo_image_three, R.drawable.demo_image_five,
            R.drawable.demo_image_four, R.drawable.demo_image_six, R.drawable.demo_image_seven};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
      //  NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    //    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
     //   NavigationUI.setupWithNavController(navView, navController);
        viewpager = (ViewPager)  findViewById(R.id.viewpager2);
        adapter = new  ViewPagerAdapter( this,images);
        viewpager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends PagerAdapter {

        // Context object
        Context context;

        // Array of images
        int[] images;

        // Layout Inflater
        LayoutInflater mLayoutInflater;


        // Viewpager Constructor
        public ViewPagerAdapter(Context context, int[] images) {
            this.context = context;
            this.images = images;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // return the number of images
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((ScrollView) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            // inflating the item.xml
            View itemView = mLayoutInflater.inflate(R.layout.item, container, false);

            // referencing the image view from the item.xml file
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);

            // setting the image in the imageView
            imageView.setImageResource(images[position]);

            // Adding the View
            Objects.requireNonNull(container).addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

          //  container.removeView((LinearLayout) object);
        }
    }

}