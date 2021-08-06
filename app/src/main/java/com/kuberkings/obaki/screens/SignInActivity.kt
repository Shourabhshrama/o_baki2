package com.kuberkings.obaki.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kuberkings.obaki.MainActivity
import com.kuberkings.obaki.R
import com.kuberkings.obaki.util.Utility

class SignInActivity : AppCompatActivity() {
   lateinit var btn_sign_in: Button
   lateinit var allraadyHaveAcccount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btn_sign_in=findViewById(R.id.btn_sign_in)
        allraadyHaveAcccount=findViewById(R.id.allraadyHaveAcccount)
        btn_sign_in.setOnClickListener {
            Utility.startActivityClass(this@SignInActivity, VerificationActivity::class.java)
            finish()
        }
        allraadyHaveAcccount.setOnClickListener {
            Utility.startActivityClass(this@SignInActivity, SignUp::class.java)
            finish()
        }
    }
}