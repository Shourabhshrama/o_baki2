package com.kuberkings.obaki.screens.category.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.home.CatModel;
import com.kuberkings.obaki.util.ClickListner;

import java.util.ArrayList;

public class CatTwoAdapter extends RecyclerView.Adapter<CatTwoAdapter.ViewHolder>{

    public ClickListner clickListner;
    private ArrayList<CatModel> localDataSet;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cat_two, parent, false);


        return new CatTwoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(localDataSet.get(position).getName());

    }

    public CatTwoAdapter(ClickListner clickListner, ArrayList<CatModel> localDataSet) {
        this.clickListner = clickListner;
        this.localDataSet = localDataSet;
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView2);

        }

        public TextView getTextView() {
            return textView;
        }
    }
}
