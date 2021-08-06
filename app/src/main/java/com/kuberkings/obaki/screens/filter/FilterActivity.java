package com.kuberkings.obaki.screens.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.MainActivity;
import com.kuberkings.obaki.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        RecyclerView mRecyclerViewCat = (RecyclerView) findViewById(R.id.filterCat);
        FilterCatAdapter mAdapter = new FilterCatAdapter(getListData(),this);
        LinearLayoutManager manager = new LinearLayoutManager(FilterActivity.this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerViewCat.setHasFixedSize(true);
        mRecyclerViewCat.setLayoutManager(manager);
        mRecyclerViewCat.setAdapter(mAdapter);



        RecyclerView mRecyclerViewCat2 = (RecyclerView) findViewById(R.id.filterSubCat);
        FilterSubCatAdapter mAdapter2 = new FilterSubCatAdapter(getList2Data(),this);
        LinearLayoutManager manager2 = new LinearLayoutManager(FilterActivity.this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerViewCat2.setHasFixedSize(true);
        mRecyclerViewCat2.setLayoutManager(manager2);
        mRecyclerViewCat2.setAdapter(mAdapter2);

        findViewById(R.id.backImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private ArrayList<Model> getListData() {
        ArrayList  mModelList = new ArrayList<>();
        Model model1=new Model("Veg",R.drawable.veg);
        Model model2=new Model("Fish",R.drawable.fish);
        Model model3=new Model("Poult",R.drawable.chicken);
        Model model4=new Model("Meat",R.drawable.meat);
        mModelList.add(model1);
        mModelList.add(model2);
        mModelList.add(model3);
        mModelList.add(model4);
        return mModelList;
    }


    private ArrayList<Model> getList2Data() {
        ArrayList  mModelList = new ArrayList<>();
        Model model1=new Model("Organic",R.drawable.veg);
        Model model2=new Model("Halal",R.drawable.fish);
        Model model3=new Model("Gluten Free",R.drawable.chicken);
        Model model4=new Model("Meat",R.drawable.meat);
        mModelList.add(model1);
        mModelList.add(model2);
        mModelList.add(model3);
        mModelList.add(model4);
        return mModelList;
    }
}