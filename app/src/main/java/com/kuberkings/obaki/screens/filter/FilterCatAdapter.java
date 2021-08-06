package com.kuberkings.obaki.screens.filter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;

import java.util.ArrayList;


public class FilterCatAdapter extends RecyclerView.Adapter<FilterCatAdapter.MyViewHolder> {

    private ArrayList<Model> mModelList;
    private Context context;

    public FilterCatAdapter(ArrayList<Model> modelList,Context context) {
        mModelList = modelList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_cat_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Model model = mModelList.get(position);
        holder.textView.setText(model.getText());
        holder.view.setBackgroundDrawable(model.isSelected() ? ContextCompat.getDrawable(context, R.drawable.orange_round) :ContextCompat.getDrawable(context, R.drawable.gray_round));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setSelected(!model.isSelected());
                holder.view.setBackgroundDrawable(model.isSelected() ? ContextCompat.getDrawable(context, R.drawable.orange_round) :ContextCompat.getDrawable(context, R.drawable.gray_round));
            }
        });

       holder. iv_cat_filter.setImageResource(mModelList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return mModelList == null ? 0 : mModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView textView;
        private ImageView iv_cat_filter;

        private MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView) itemView.findViewById(R.id.text_view);
            iv_cat_filter = (ImageView) itemView.findViewById(R.id.iv_cat_filter);
        }
    }
}
