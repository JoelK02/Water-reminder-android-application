package com.firebaseauthdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var btn_submit:Button
    lateinit var et_forgot_email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btn_submit = findViewById(R.id.btn_submit)
        et_forgot_email = findViewById(R.id.et_register_email)

        btn_submit.setOnClickListener {

            val email: String = et_forgot_email.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this@ForgotPasswordActivity, "Please enter email.", Toast.LENGTH_SHORT).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this@ForgotPasswordActivity, "Email sent successfully to reset your password!.", Toast.LENGTH_LONG).show()
                        finish()
                        //  if user enter not  exist email
                    }else{
                        Toast.makeText(this@ForgotPasswordActivity,task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }
}