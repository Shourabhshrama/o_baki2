package com.kuberkings.obaki.screens.notification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.chat.Message;
import com.kuberkings.obaki.screens.notification.model.OrderStatusModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PastNotificaionAdapter extends RecyclerView.Adapter<PastNotificaionAdapter.MyMessageViewHolder> {

    ArrayList<Message> list = new ArrayList<>();
    PastNotificaionAdapter.OnMessageActionListner onMessageActionListner;
    Context context;

  public PastNotificaionAdapter(Context context, ArrayList<Message> list, PastNotificaionAdapter.OnMessageActionListner onMessageActionListner) {
        this.list = list;
        this.context=context;
        this.onMessageActionListner = onMessageActionListner;
    }

    @NonNull
    @Override
    public  PastNotificaionAdapter.MyMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_notification_item_row, parent, false);

        return new PastNotificaionAdapter.MyMessageViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull PastNotificaionAdapter.MyMessageViewHolder holder, int position) {
//        holder.messageTitle.setText(list.get(position).getName());
//        holder.message.setText(list.get(position).getLastMessage());
//        holder.messageTime.setText(list.get(position).getTime());
//        //  holder.messageCount.setText("" + list.get(position).getCount());
//        holder.messageImage.setImageResource(list.get(position).getImage());

        ArrayList<OrderStatusModel> arrayOfStatus = new ArrayList<>();
        arrayOfStatus.add(new OrderStatusModel("Order Rcived", "8:30am,Jan 31,2018"));
        arrayOfStatus.add(new OrderStatusModel("On The Way", "10:30am,Jan 31,2018"));
        arrayOfStatus.add(new OrderStatusModel("Delivered", "aaaaaa"));
        OrderStatusAdapter adapter = new OrderStatusAdapter(context, arrayOfStatus);

       holder. list.setAdapter(adapter);


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
        ListView list;
        //  TextView messageCount;
        CircleImageView messageImage;
        LinearLayout layoutMessage;

        public MyMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_action_message = itemView.findViewById(R.id.ll_action_message);
            messageImage = itemView.findViewById(R.id.messageImage);
            messageTitle = itemView.findViewById(R.id.messageTitle);
            list = itemView.findViewById(R.id.list);
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
