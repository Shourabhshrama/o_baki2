package com.kuberkings.obaki;

import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;


import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.kuberkings.obaki.databinding.ActivitySplashBindingImpl;
import com.kuberkings.obaki.screens.SignUp;
import com.kuberkings.obaki.util.PreferenceConnector;
import com.kuberkings.obaki.util.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBindingImpl mBinding;
    private Handler handler;
    private ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        setSplashScreenTimer();
        getKeyHash();
    }
    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected boolean isProgressDialogShowing() {
        if (progressDialog != null) {
            return progressDialog.isShowing();
        } else {
            return false;
        }
    }

    protected void showProgressDialog(@StringRes Integer messageId) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);

            // Disable the back button
            DialogInterface.OnKeyListener keyListener = (dialog, keyCode, event) -> keyCode == KeyEvent.KEYCODE_BACK;
            progressDialog.setOnKeyListener(keyListener);
        }
        progressDialog.setMessage(getString(messageId));
        try {
            progressDialog.show();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.d("TAG", e.getMessage());
            }
        }
    }

    private void getKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.mycar.app", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sign = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.e("MY KEY HASH:", sign);
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            Log.d("Exception", e.getMessage());
        }
    }

    // start time for splash screen
    private void setSplashScreenTimer() {
        handler = new Handler();
        handler.postDelayed(() -> {
            boolean isLogin = PreferenceConnector.readBoolean( SplashActivity.this, PreferenceConnector.IS_LOGIN, false);
            if (isLogin) {
                Utility.startActivity(SplashActivity.this, MainActivity.class);
                finish
                        ();

            } else {
                Utility.startActivityClass(SplashActivity.this, SignUp.class);
                finish();
            }

        }, 3000);
    }


}
