package com.kuberkings.obaki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.ClickListner;

public class HomeDishAdapter extends RecyclerView.Adapter<HomeDishAdapter.ViewHolder> {

    public ClickListner clickListner;
    private String[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     * @param clickListner
     */
    public HomeDishAdapter(String[] dataSet, ClickListner clickListner) {
        localDataSet = dataSet;
       this.clickListner=clickListner;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_home_dish_item, viewGroup, false);


        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
      //  viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.itemView.findViewById(R.id.imaveViewRest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onclickItem(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 10;
    }


}