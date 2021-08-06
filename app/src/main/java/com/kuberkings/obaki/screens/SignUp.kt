package com.kuberkings.obaki.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kuberkings.obaki.MainActivity
import com.kuberkings.obaki.R

import com.kuberkings.obaki.util.Utility


class SignUp : AppCompatActivity() {
    var btnNext: Button? = null
    var allraadyHaveAcccount: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnNext = findViewById<Button>(R.id.btn_next);
        allraadyHaveAcccount = findViewById<Button>(R.id.allraadyHaveAcccount);
        btnNext?.setOnClickListener {
            Utility.startActivityClass(this@SignUp, VerificationActivity::class.java)

        }
        allraadyHaveAcccount?.setOnClickListener {
            Utility.startActivityClass(this@SignUp, SignInActivity::class.java)
            finish()
        }

    }

//    fun onCountryPickerClick(view: View?) {
//
//    }
}