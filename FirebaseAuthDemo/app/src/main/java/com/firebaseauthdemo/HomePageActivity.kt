package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class HomePageActivity : AppCompatActivity() {

    lateinit var tv_username:TextView
    lateinit var card1: CardView
    lateinit var card2: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        tv_username = findViewById(R.id.tv_username)
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)

        /*card1.setOnClickListener {

            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
        }*/


        card2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}