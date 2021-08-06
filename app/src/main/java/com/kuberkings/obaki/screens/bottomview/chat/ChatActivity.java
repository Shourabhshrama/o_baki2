package com.kuberkings.obaki.screens.bottomview.chat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.databinding.ActivityChatBinding;


import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ActivityChatBinding chatBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        chatBinding.setActivity(this);
        ArrayList<ChatModel> messageList = new ArrayList();
        messageList.add(new ChatModel(1, "Hello", "Chryssa"));
        messageList.add(new ChatModel(2, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(3, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(4, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(5, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(6, "You too", "JavaCodeGeeks"));
        messageList.add(new ChatModel(7, "Hello", "Chryssa"));
        messageList.add(new ChatModel(8, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(9, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(10, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(11, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(12, "You too", "JavaCodeGeeks"));
        messageList.add(new ChatModel(13, "Hello", "Chryssa"));
        messageList.add(new ChatModel(14, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(15, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(16, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(17, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(18, "You too", "JavaCodeGeeks"));

        messageList.add(new ChatModel(19, "Hello", "Chryssa"));
        messageList.add(new ChatModel(20, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(21, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(22, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(23, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(24, "You too", "JavaCodeGeeks"));
        messageList.add(new ChatModel(25, "Hello", "Chryssa"));
        messageList.add(new ChatModel(26, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(27, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(28, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(29, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(30, "You too", "JavaCodeGeeks"));
        messageList.add(new ChatModel(31, "Hello", "Chryssa"));
        messageList.add(new ChatModel(32, "Hello", "JavaCodeGeeks"));
        messageList.add(new ChatModel(33, "This is an example about RecyclerView", "Chryssa"));
        messageList.add(new ChatModel(34, "Great news!", "JavaCodeGeeks"));
        messageList.add(new ChatModel(35, "Enjoy reading!", "Chryssa"));
        messageList.add(new ChatModel(36, "You too", "JavaCodeGeeks"));

        chatBinding.recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        chatBinding.recyclerViewChat.setAdapter(new ChatAdapter(this,messageList));
    }

    public void onClickBack() {
        onBackPressed();
    }
}