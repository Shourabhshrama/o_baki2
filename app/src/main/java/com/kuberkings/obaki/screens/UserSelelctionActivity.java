package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kuberkings.obaki.MainActivity;
import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.Utility;

public class UserSelelctionActivity extends AppCompatActivity {
   TextView userOne;
   TextView userTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selelction);
        userOne=(TextView) findViewById(R.id.userOne);
        userTwo=(TextView) findViewById(R.id.userTwo);

        userOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass( UserSelelctionActivity.this, ServiceSelectionActivity.class);
                finish();
            }
        });


        userTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass( UserSelelctionActivity.this, ServiceSelectionActivity.class);
                finish();
            }
        });
    }
}