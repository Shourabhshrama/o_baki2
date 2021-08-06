package com.kuberkings.obaki.screens.bottomview.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyMessageAdapter extends RecyclerView.Adapter<MyMessageAdapter.MyMessageViewHolder> {

    ArrayList<Message> list = new ArrayList<>();
    OnMessageActionListner onMessageActionListner;

    MyMessageAdapter(ArrayList<Message> list, OnMessageActionListner onMessageActionListner) {
        this.list = list;
        this.onMessageActionListner = onMessageActionListner;
    }

    @NonNull
    @Override
    public MyMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_row, parent, false);

        return new MyMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMessageViewHolder holder, int position) {
        holder.messageTitle.setText(list.get(position).getName());
        holder.message.setText(list.get(position).getLastMessage());
        holder.messageTime.setText(list.get(position).getTime());
      //  holder.messageCount.setText("" + list.get(position).getCount());
        holder.messageImage.setImageResource(list.get(position).getImage());

        holder.layoutMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onMessageActionListner.onMessageClick(list.get(position));
            }
        });
        holder.status.setText(list.get(position).getStatus());
        if(list.get(position).getStatus().equals("Accepted")){
             holder.status.setBackgroundResource(R.drawable.accepted_message_back_round);
             holder.status.setTextColor( holder.itemView.getContext().getResources().getColor(R.color.price_color));
             holder.btn_write_review.setVisibility(View.VISIBLE);
             holder.ll_action_message.setVisibility(View.GONE);


        }else  if(list.get(position).getStatus().equals("Request")){
            holder.status.setBackgroundResource(R.drawable.request_message_back_round);
            holder.status.setTextColor( holder.itemView.getContext().getResources().getColor(R.color.colorPrimary));
            holder.btn_write_review.setVisibility(View.GONE);
            holder.ll_action_message.setVisibility(View.VISIBLE);

        }else if(list.get(position).getStatus().equals("Canceled")){
            holder.status.setBackgroundResource(R.drawable.cancel_message_back_round);
            holder.status.setTextColor( holder.itemView.getContext().getResources().getColor(R.color.end_color));
            holder.btn_write_review.setVisibility(View.GONE);
            holder.ll_action_message.setVisibility(View.GONE);
        }else {
            holder.status.setBackgroundResource(R.drawable.inquiry_message_back_round);
            holder.status.setTextColor( holder.itemView.getContext().getResources().getColor(R.color.black));
            holder.btn_write_review.setVisibility(View.GONE);
            holder.ll_action_message.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyMessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageTitle;
        TextView messageTime;
        TextView message;
        TextView btn_write_review;
        TextView status;
        LinearLayout ll_action_message;
      //  TextView messageCount;
        CircleImageView messageImage;
        LinearLayout layoutMessage;

        public MyMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_action_message = itemView.findViewById(R.id.ll_action_message);
            messageImage = itemView.findViewById(R.id.messageImage);
            messageTitle = itemView.findViewById(R.id.messageTitle);
            message = itemView.findViewById(R.id.message);
            btn_write_review = itemView.findViewById(R.id.btn_write_review);
            status = itemView.findViewById(R.id.status);
            messageTime = itemView.findViewById(R.id.messageTime);
          //  messageCount = itemView.findViewById(R.id.messageCount);
            layoutMessage = itemView.findViewById(R.id.layoutMessage);

        }

    }

   public interface OnMessageActionListner {
        void onMessageClick(Message message);
    }

}
