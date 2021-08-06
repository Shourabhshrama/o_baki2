package com.kuberkings.obaki.screens.bottomview.orders.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.orders.Order;

import java.util.ArrayList;


public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.ViewHolder> {

     private ArrayList<Order> orderArrayList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public   class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView btn_order_cancel;
        private final TextView btn_order_re_order;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.orderStutus);
            btn_order_cancel = (TextView) view.findViewById(R.id.btn_order_cancel);
            btn_order_re_order = (TextView) view.findViewById(R.id.btn_order_re_order);

        }


        public void bindData(Order order) {
            textView.setText(order.getStatus());
            if(order.getStatus().equals("Upcoming")){
                btn_order_cancel.setVisibility(View.VISIBLE);
                btn_order_re_order.setVisibility(View.GONE);

            }else if(order.getStatus().equals("Completed")){
                btn_order_cancel.setVisibility(View.GONE);
                btn_order_re_order.setVisibility(View.VISIBLE);

            }else {
                btn_order_cancel.setVisibility(View.GONE);
                btn_order_re_order.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public AllOrderAdapter(ArrayList<Order> dataSet) {
       this. orderArrayList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AllOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_al_order_item, viewGroup, false);

        return new AllOrderAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bindData(orderArrayList.get(position));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return orderArrayList.size();
    }
}