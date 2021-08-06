package com.kuberkings.obaki.screens.bottomview.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.adapter.HomeOrderAdapter;
import com.kuberkings.obaki.screens.bottomview.orders.adapter.AllOrderAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerviewAllOrders;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllOrderFragment newInstance(String param1, String param2) {
        AllOrderFragment fragment = new AllOrderFragment();
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
        View view= inflater.inflate(R.layout.fragment_all_order, container, false);
        recyclerviewAllOrders= view.findViewById(R.id.recyclerviewAllOrders);
        recyclerviewAllOrders.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ArrayList<Order> orders=new ArrayList<>();
        Order order=new Order();
        order.setName("Local Vibe");
        order.setAddress("Dubai International City, T-9001, 2.2km Away");
        order.setStatus("Upcoming");
        order.setPurhcaseDate("16/06/2021, 14:00");
        order.setCat("Fish, Pork");
        order.setNumberOfPersons("4 Person");

        Order order1=new Order();
        order1.setName("Eco House");
        order1.setAddress("Dubai International City, T-9001, 2.2km Away");
        order1.setStatus("Completed");
        order1.setPurhcaseDate("16/06/2021, 14:00");
        order1.setCat("Meat, Pork");
        order1.setNumberOfPersons("10 Person");

        Order order2=new Order();
        order2.setName("Local Vibe");
        order2.setAddress("Dubai International City, T-9001, 2.2km Away");
        order2.setStatus("Verifying");
        order2.setPurhcaseDate("16/06/2021, 14:00");
        order2.setCat("Fish, Pork");
        order2.setNumberOfPersons("4 Person");
        orders.add(order);
        orders.add(order1);
        orders.add(order2);

        recyclerviewAllOrders.setAdapter(new AllOrderAdapter(orders));

        return view;
    }
}