package com.kuberkings.obaki.screens.category.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.home.CatModel;
import com.kuberkings.obaki.screens.category.adapter.CatItemAdapter;
import com.kuberkings.obaki.screens.category.adapter.CatOneAdapter;
import com.kuberkings.obaki.screens.category.adapter.CatTwoAdapter;
import com.kuberkings.obaki.util.ClickListner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeaturedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeaturedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeaturedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeaturedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeaturedFragment newInstance(String param1, String param2) {
        FeaturedFragment fragment = new FeaturedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_featured, container, false);
        RecyclerView rv_recyclerview_cat1= view.findViewById(R.id.rv_recyclerview_cat1);
        rv_recyclerview_cat1.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, true));
        CatModel catModel=new CatModel("Country Side",R.drawable.country_side);
        CatModel catModel2=new CatModel("Mountain",R.drawable.mountain);
        CatModel catModel3=new CatModel("Beach",R.drawable.beach);
        CatModel catModel4=new CatModel("City",R.drawable.city);
        ArrayList<CatModel> catModels=new ArrayList<>();
        catModels.add(catModel);
        catModels.add(catModel2);
        catModels.add(catModel3);
        catModels.add(catModel4);

        rv_recyclerview_cat1.setAdapter(new CatOneAdapter(new ClickListner() {
            @Override
            public void onclickItem(int position) {

            }
        },catModels));



        RecyclerView rv_recyclerview_cat2= view.findViewById(R.id.rv_recyclerview_cat2);
        rv_recyclerview_cat2.setLayoutManager( new GridLayoutManager(view.getContext(),4));
        CatModel cat1=new CatModel("Chicken",R.drawable.country_side);
        CatModel cat2=new CatModel("Dessert",R.drawable.mountain);
        CatModel cat3=new CatModel("Organic",R.drawable.beach);
        CatModel cat4=new CatModel("Healthy",R.drawable.city);
        CatModel cat5=new CatModel("Steak",R.drawable.city);
        CatModel cat6=new CatModel("Italian",R.drawable.city);
        CatModel cat7=new CatModel("Lunch",R.drawable.city);
        CatModel cat8=new CatModel("India",R.drawable.city);
        CatModel cat9=new CatModel("Appetizer",R.drawable.city);
        ArrayList<CatModel> catModels2=new ArrayList<>();
        catModels2.add(cat1);
        catModels2.add(cat2);
        catModels2.add(cat3);
        catModels2.add(cat4);
        catModels2.add(cat5);
        catModels2.add(cat6);
        catModels2.add(cat7);
        catModels2.add(cat8);
        catModels2.add(cat9);



        rv_recyclerview_cat2.setAdapter(new CatTwoAdapter(new ClickListner() {
            @Override
            public void onclickItem(int position) {

            }
        },catModels2));









        RecyclerView rv_recyclerview_cat3= view.findViewById(R.id.rv_recyclerview_cat3);
        rv_recyclerview_cat3.setLayoutManager( new GridLayoutManager(view.getContext(),2));
        CatModel cat11=new CatModel("Thai",R.drawable.thai);
        CatModel cat12=new CatModel("Japanese",R.drawable.japaneas);
        CatModel cat13=new CatModel("Korean",R.drawable.korean);
        CatModel cat14=new CatModel("Halal",R.drawable.halal);
        CatModel cat15=new CatModel("Kosher",R.drawable.kosher);
        CatModel cat16=new CatModel("Vietnamese",R.drawable.vieat);

        ArrayList<CatModel> catModels21=new ArrayList<>();
        catModels21.add(cat11);
        catModels21.add(cat12);
        catModels21.add(cat13);
        catModels21.add(cat14);
        catModels21.add(cat15);
        catModels21.add(cat16);




        rv_recyclerview_cat3.setAdapter(new CatItemAdapter(catModels21,new ClickListner() {
            @Override
            public void onclickItem(int position) {

            }
        }));




        return view;
    }
}