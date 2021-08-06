package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.databinding.ActivityChefCheckoutBinding;

public class ChefCheckoutActivity extends AppCompatActivity {
    ActivityChefCheckoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_chef_checkout);

        binding.btnChefExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }


    public void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom_chef_order);
        dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_shape));

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_continue_order_success);
       ImageView clsoeBtn= dialog.findViewById(R.id.extra_checf_close);
        clsoeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}