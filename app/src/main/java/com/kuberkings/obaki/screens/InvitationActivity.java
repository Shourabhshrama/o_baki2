package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.Utility;

public class InvitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
        findViewById(R.id.btn_invitation_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(InvitationActivity.this, FillUserInfoActivity.class);

            }
        });

    }
}