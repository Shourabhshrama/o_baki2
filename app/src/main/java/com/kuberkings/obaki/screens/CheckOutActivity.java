package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;


import com.kuberkings.obaki.R;
import com.kuberkings.obaki.databinding.ActivityCheckOutBinding;


public class CheckOutActivity extends AppCompatActivity {
    ActivityCheckOutBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding=    DataBindingUtil.setContentView(this, R.layout.activity_check_out);
        dataBinding.btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }


    public void showDialog(){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.success_dialog);
        dialog.getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_shape));

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_continue_order_success);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


}




