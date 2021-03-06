package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HomePageActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var  username: DatabaseReference
    lateinit var tv_username:TextView
    lateinit var card1: CardView
    lateinit var card2: CardView
    lateinit var btn_logout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        tv_username = findViewById(R.id.tv_username)
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)
        btn_logout = findViewById(R.id.btn_logout)

        auth = FirebaseAuth.getInstance() // link to authentication
        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/") //link to realtime firebase
        username = database.getReference().child("Users") // database = link to realtime firebase, .getReference = see the content of firebase, .child("Users")= link to Users


        // link to authentication to check current user
        val user = auth.currentUser // see current user in avd

        // realtime firebase
        // ? = check the presence of user
        val username = username.child(user?.uid!!) // lookup to user.uid

        // real time database activity
        // listen to the event changes
        username.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                // read data here
                // .child = user.uid
                // snapshot data inside user.uid
                val name = snapshot.child("Username").value.toString()
                tv_username.text = name
            }

            // appear after error
            override fun onCancelled(error: DatabaseError) {
            }

        })


        card1.setOnClickListener {
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
        }

        card2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@HomePageActivity, LoginActivity::class.java))
            finish()
        }




    }
}