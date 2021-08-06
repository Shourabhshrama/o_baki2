package com.kuberkings.obaki.screens.bottomview.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.Utility;

import java.util.ArrayList;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    ArrayList<Message> messages=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final RecyclerView myMessageListRecycler = root.findViewById(R.id.myMessageListRecycler);
        myMessageListRecycler.setLayoutManager(new LinearLayoutManager(root.getContext()));
        MyMessageAdapter myMessageAdapter = new MyMessageAdapter(getMessage(), new  MyMessageAdapter.OnMessageActionListner() {
            @Override
            public void onMessageClick(Message message) {
               Utility.startActivity(getActivity(), ChatActivity.class);
            }
        });
      //  myMessageListRecycler.setNestedScrollingEnabled(false);
        myMessageListRecycler.addItemDecoration(new DividerItemDecoration(root.getContext(), DividerItemDecoration.VERTICAL));
        myMessageListRecycler.setAdapter(myMessageAdapter);
        return root;
    }

    public   ArrayList<Message> getMessage() {
        messages.add(new Message(R.drawable.chef, "Sharon", "Hi,When my package Will Arrive?", 2, "8:20","Accepted"));
        messages.add(new Message(R.drawable.chef, "Rodney", "File Icon + File", 0, "9:20","Request"));
        messages.add(new Message(R.drawable.chef, "Erika", "Product Icon + Product", 2, "Yesterday","Accepted"));
        messages.add(new Message(R.drawable.chef, "Chad", "Image", 0, "Yesterday","Canceled"));
        messages.add(new Message(R.drawable.chef, "Rodney", "Order Icon + Order", 0, "Yesterday","Inquiry"));
        return messages;
    }
}