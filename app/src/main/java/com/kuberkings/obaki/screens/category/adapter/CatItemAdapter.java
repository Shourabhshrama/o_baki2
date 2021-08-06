package com.kuberkings.obaki.screens.category.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.screens.bottomview.home.CatModel;
import com.kuberkings.obaki.util.ClickListner;

import java.util.ArrayList;

public class CatItemAdapter extends RecyclerView.Adapter<CatItemAdapter.ViewHolder> {

    private ArrayList<CatModel> localDataSet;
private ClickListner clickListner;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView iamgeCat;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.itemCatName);
            iamgeCat = (ImageView) view.findViewById(R.id.ItemCat);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return iamgeCat;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     * @param onClickListener
     */
    public CatItemAdapter(ArrayList<CatModel> dataSet, ClickListner onClickListener) {
        localDataSet = dataSet;
        this.clickListner=onClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_cat_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(position).getName());
        viewHolder.getImageView().setImageResource(localDataSet.get(position).getIcon());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}