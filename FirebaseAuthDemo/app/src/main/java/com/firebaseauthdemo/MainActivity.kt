package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var  reference: DatabaseReference

    lateinit var tv_user_id: TextView
    lateinit var tv_email_id: TextView
    lateinit var btn_logout:Button
    lateinit var et_data: TextView
    lateinit var btn_submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")
        reference = database.getReference("Cup1")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        // database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")
        // reference = database.getReference("Users")
        // getData()

        tv_user_id = findViewById(R.id.tv_user_id)
        tv_email_id = findViewById(R.id.tv_email_id)
        btn_logout = findViewById(R.id.btn_logout)
        et_data = findViewById(R.id.et_data)
        btn_submit = findViewById(R.id.btn_submit)


        val userId= intent.getStringExtra("userid")
        val emailId = intent.getStringExtra("emailid")


        tv_user_id.text = "User ID :$userId"
        tv_email_id.text = "Email ID : $emailId"

        btn_submit.setOnClickListener {
            // sendData()
        }

        btn_logout.setOnClickListener{
            // Logout from app.
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish() // exit from current activity

        }
    }


}