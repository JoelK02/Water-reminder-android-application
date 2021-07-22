package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var  cup1: DatabaseReference
    private lateinit var  cup2: DatabaseReference
    private lateinit var  cup3: DatabaseReference
    private lateinit var  cup4: DatabaseReference
    private lateinit var  cup5: DatabaseReference
    private lateinit var  cup6: DatabaseReference
    private lateinit var  cup7: DatabaseReference
    private lateinit var  cup8: DatabaseReference





    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        cup1 = database.getReference().child("Cup1")
        cup2 = database.getReference().child("Cup2")
        cup3 = database.getReference().child("Cup3")
        cup4 = database.getReference().child("Cup4")
        cup5 = database.getReference().child("Cup5")
        cup6 = database.getReference().child("Cup6")
        cup7 = database.getReference().child("Cup7")
        cup8 = database.getReference().child("Cup8")


        val btn_logout = findViewById<Button>(R.id.btn_logout)

        checkWater()

        btn_logout.setOnClickListener {
            // Logout from app.
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish() // exit from current activity

        }
    }


    private fun CupTime(waterStatus: Any, cup: Any, time: Int) {


        val user = auth.currentUser
        val glass1 = findViewById<ImageView>(R.id.glass1)
        val glass2 = findViewById<ImageView>(R.id.glass2)
        val glass3 = findViewById<ImageView>(R.id.glass3)
        val glass4 = findViewById<ImageView>(R.id.glass4)
        val glass5 = findViewById<ImageView>(R.id.glass5)
        val glass6 = findViewById<ImageView>(R.id.glass6)
        val glass7 = findViewById<ImageView>(R.id.glass7)
        val glass8 = findViewById<ImageView>(R.id.glass8)
        val hour = SimpleDateFormat("HH").format(Calendar.getInstance().time).toInt()


        if (hour >= time && waterStatus == "0") {
            if (cup == "1") {
                glass1.setImageResource(R.drawable.glass_water)
                glass1.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass1.setImageResource(R.drawable.empty_glass)
                    cup1.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "2") {
                glass2.setImageResource(R.drawable.glass_water)
                glass2.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass2.setImageResource(R.drawable.empty_glass)
                    cup2.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "3") {
                glass3.setImageResource(R.drawable.glass_water)
                glass3.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass3.setImageResource(R.drawable.empty_glass)
                    cup3.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "4") {
                glass4.setImageResource(R.drawable.glass_water)
                glass4.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass4.setImageResource(R.drawable.empty_glass)
                    cup4.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "5") {
                glass5.setImageResource(R.drawable.glass_water)
                glass5.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass5.setImageResource(R.drawable.empty_glass)
                    cup5.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "6") {
                glass6.setImageResource(R.drawable.glass_water)
                glass6.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass6.setImageResource(R.drawable.empty_glass)
                    cup6.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "7") {
                glass7.setImageResource(R.drawable.glass_water)
                glass7.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass7.setImageResource(R.drawable.empty_glass)
                    cup7.child(user?.uid!!).updateChildren(updateTo1())

                }
            }
            if (cup == "8") {
                glass8.setImageResource(R.drawable.glass_water)
                glass8.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                    updateTo1()
                    glass8.setImageResource(R.drawable.empty_glass)
                    cup8.child(user?.uid!!).updateChildren(updateTo1())

                }
            }


        }  else if (hour < time){
            if (cup == "1") {
                glass1.setImageResource(R.drawable.glass_water)
                glass1.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup1.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "2") {
                glass2.setImageResource(R.drawable.glass_water)
                glass2.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup2.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "3") {
                glass3.setImageResource(R.drawable.glass_water)
                glass3.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup3.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "4") {
                glass4.setImageResource(R.drawable.glass_water)
                glass4.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup4.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "5") {
                glass5.setImageResource(R.drawable.glass_water)
                glass5.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup5.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "6") {
                glass6.setImageResource(R.drawable.glass_water)
                glass6.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup6.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "7") {
                glass7.setImageResource(R.drawable.glass_water)
                glass7.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup7.child(user?.uid!!).updateChildren(updateTo0())
            }
            if (cup == "8") {
                glass8.setImageResource(R.drawable.glass_water)
                glass8.setOnClickListener {
                    Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
                }
                updateTo0()
                cup8.child(user?.uid!!).updateChildren(updateTo0())
            }



        } else {
            if (cup == "1") {
                glass1.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass1.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "2") {
                glass2.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass2.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "3") {
                glass3.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass3.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "4") {
                glass4.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass4.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "5") {
                glass5.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass5.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "6") {
                glass6.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass6.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "7") {
                glass7.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass7.setImageResource(R.drawable.empty_glass)
            }
            if (cup == "8") {
                glass8.setOnClickListener {
                    Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                        .show()
                }
                glass8.setImageResource(R.drawable.empty_glass)
            }
        }
    }

    private fun checkWater() {

        val user = auth.currentUser
        val cup1 = cup1.child(user?.uid!!)
        val cup2 = cup2.child(user.uid)
        val cup3 = cup3.child(user.uid)
        val cup4 = cup4.child(user.uid)
        val cup5 = cup5.child(user.uid)
        val cup6 = cup6.child(user.uid)
        val cup7 = cup7.child(user.uid)
        val cup8 = cup8.child(user.uid)

// First Cup
        cup1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "1"
                val time = 8
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Second Cup
        cup2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "2"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Third Cup
        cup3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "3"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Fourth Cup
        cup4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "4"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Fifth Cup
        cup5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "5"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Sixth Cup
        cup6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "6"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Seventh Cup
        cup2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "7"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
// Eighth Cup
        cup8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val cup = "8"
                val time = 10
                val waterStatus = snapshot.child("Data").value
                if (waterStatus != null) {
                    CupTime(waterStatus, cup, time)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
    }

    private fun updateTo0(): Map<String, String> {
        val update = mapOf<String,String>(
            "Data" to "0"
        )

        return update
    }

    private fun updateTo1(): Map<String, String> {
        val update = mapOf<String,String>(
            "Data" to "1"
        // add cumulative score
        )

        return update
    }

    }

