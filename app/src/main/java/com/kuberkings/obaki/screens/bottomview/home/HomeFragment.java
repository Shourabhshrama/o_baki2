package com.kuberkings.obaki.screens.bottomview.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.adapter.HomeCatAdapter;
import com.kuberkings.obaki.adapter.HomeChefAdapter;
import com.kuberkings.obaki.adapter.HomeDish2Adapter;
import com.kuberkings.obaki.adapter.HomeDishAdapter;
import com.kuberkings.obaki.adapter.HomeOrderAdapter;
import com.kuberkings.obaki.screens.ChefPorifleActivity;
import com.kuberkings.obaki.screens.OnBoardingActivity;
import com.kuberkings.obaki.screens.OnBoardingPagerActivity;
import com.kuberkings.obaki.screens.RestaurentDetailActivity;
import com.kuberkings.obaki.screens.category.SearchCatctivity;
import com.kuberkings.obaki.screens.filter.FilterActivity;
import com.kuberkings.obaki.util.ClickListner;
import com.kuberkings.obaki.util.StartSnapHelper;
import com.kuberkings.obaki.util.Utility;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    ViewPager viewpager;
    private HomeViewModel homeViewModel;
    ImageView AppImageTOChange;
    OnBoardingPagerActivity.MyPagerAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        root.findViewById(R.id.filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(getActivity(), FilterActivity.class);
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        ArrayList<CatModel> models=new ArrayList<>();
        models.add(new CatModel("Chinese",R.drawable.ic_pasta__1_));
        models.add(new CatModel("Italian",R.drawable.pizza));
        models.add(new CatModel("Seafood",R.drawable.ic_shrimp));
        models.add(new CatModel("Vegan",R.drawable.ic_cabbage));
        RecyclerView homeCat= root.findViewById(R.id.rv_recyclerview_cat);
        homeCat.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        homeCat.setAdapter(new HomeCatAdapter(models,new  ClickListner() {
            @Override
            public void onclickItem(int position) {
                Utility.startActivityClass(getActivity(), SearchCatctivity.class);
            }
        }));




        RecyclerView rv_recyclerview1= root.findViewById(R.id.rv_recyclerview1);
        rv_recyclerview1.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_recyclerview1.setAdapter(new HomeDishAdapter(new String[10], new  ClickListner() {
            @Override
            public void onclickItem(int position) {
                Utility.startActivityClass(getActivity(), RestaurentDetailActivity.class);
            }
        }));

        RecyclerView rv_recyclerview2= root.findViewById(R.id.rv_recyclerview2);
        rv_recyclerview2.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_recyclerview2.setAdapter(new HomeDish2Adapter(new String[10]));

        RecyclerView rv_recyclerview3= root.findViewById(R.id.rv_recyclerview3);
        rv_recyclerview3.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_recyclerview3.setAdapter(new HomeDish2Adapter(new String[10]));

        RecyclerView rv_recyclerview_chef= root.findViewById(R.id.rv_recyclerview_chef);
        rv_recyclerview_chef.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_recyclerview_chef.setAdapter(new HomeChefAdapter(new String[10], new ClickListner() {
            @Override
            public void onclickItem(int position) {
                Utility.startActivityClass(getActivity(), ChefPorifleActivity.class);
            }
        }));


        RecyclerView rv_recyclerview_order_again= root.findViewById(R.id.rv_recyclerview_order_again);
        rv_recyclerview_order_again.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        rv_recyclerview_order_again.setAdapter(new HomeOrderAdapter(new String[10],new  ClickListner() {
            @Override
            public void onclickItem(int position) {
                Utility.startActivityClass(getActivity(), RestaurentDetailActivity.class);
            }
        }));

        StartSnapHelper snapHelper = new StartSnapHelper();
        snapHelper.attachToRecyclerView(homeCat);
        snapHelper.attachToRecyclerView(rv_recyclerview2);
        snapHelper.attachToRecyclerView(rv_recyclerview3);
        snapHelper.attachToRecyclerView(rv_recyclerview_chef);
        snapHelper.attachToRecyclerView(rv_recyclerview_order_again);
        return root;


    }


}