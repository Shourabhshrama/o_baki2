package com.kuberkings.obaki.screens.bottomview.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.kuberkings.obaki.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private Activity mActivity;
    private ArrayList<ChatModel> items = new ArrayList<>();
    public static final int SENDER = 0;
    public static final int RECEIVER = 1;

    public ChatAdapter(Activity mActivity, ArrayList<ChatModel> items) {
        this.mActivity = mActivity;
        this.items = items;
    }

    @NonNull
    @Override
    public  ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_reciver, parent, false);
            ViewHolder vh = new ViewHolder((LinearLayout) v);
            return vh;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_sender, parent, false);
            ViewHolder vh = new ViewHolder((LinearLayout) v);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull  ChatAdapter.ViewHolder holder, int position) {
        //holder.reciveMsgTxt.setText(items.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatModel message = items.get(position);

        if (message.getSenderName().equals("Chryssa")) {
            return SENDER;
        } else {
            return RECEIVER;
        }

    }

    public void remove(int pos) {
        int position = pos;
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView reciveMsgTxt;
        private TextView senderMsgTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            reciveMsgTxt = itemView.findViewById(R.id.reciveMsgTxt);
            senderMsgTxt = itemView.findViewById(R.id.senderMsgTxt);
        }
    }
}
