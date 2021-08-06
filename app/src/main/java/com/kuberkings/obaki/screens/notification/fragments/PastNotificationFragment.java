package com.kuberkings.obaki.screens.notification.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.chat.ChatActivity;
import com.kuberkings.obaki.screens.bottomview.chat.Message;
import com.kuberkings.obaki.screens.notification.adapter.NotificaionAdapter;
import com.kuberkings.obaki.screens.notification.adapter.PastNotificaionAdapter;
import com.kuberkings.obaki.util.Utility;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastNotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastNotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Message> messages=new ArrayList<>();

    public PastNotificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastNotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastNotificationFragment newInstance(String param1, String param2) {
        PastNotificationFragment fragment = new PastNotificationFragment();
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

        messages.add(new Message(R.drawable.chef, "Sharon", "Hi,When my package Will Arrive?", 2, "8:20","Accepted"));
        messages.add(new Message(R.drawable.chef, "Rodney", "File Icon + File", 0, "9:20","Request"));
        messages.add(new Message(R.drawable.chef, "Erika", "Product Icon + Product", 2, "Yesterday","Accepted"));
        messages.add(new Message(R.drawable.chef, "Chad", "Image", 0, "Yesterday","Canceled"));
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_past_notification, container, false);
        final RecyclerView myMessageListRecycler = view.findViewById(R.id.myMessageListRecycler);
        myMessageListRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        PastNotificaionAdapter notificaionAdapter = new PastNotificaionAdapter(view.getContext(),messages, new  PastNotificaionAdapter.OnMessageActionListner() {
            @Override
            public void onMessageClick(Message message) {
                Utility.startActivity(getActivity(), ChatActivity.class);
            }
        });
        //  myMessageListRecycler.setNestedScrollingEnabled(false);
        myMessageListRecycler.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        myMessageListRecycler.setAdapter(notificaionAdapter);
        return view;
    }
}