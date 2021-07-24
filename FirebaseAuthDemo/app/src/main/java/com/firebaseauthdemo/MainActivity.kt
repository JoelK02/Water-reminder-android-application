package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var  skin: DatabaseReference
    private lateinit var  coin: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()


        cup1 = database.getReference().child("Cup1")
        cup2 = database.getReference().child("Cup2")
        cup3 = database.getReference().child("Cup3")
        cup4 = database.getReference().child("Cup4")
        cup5 = database.getReference().child("Cup5")
        cup6 = database.getReference().child("Cup6")
        cup7 = database.getReference().child("Cup7")
        cup8 = database.getReference().child("Cup8")
        skin = database.getReference().child("Users")
        coin = database.getReference().child("Users")


        val user = auth.currentUser
        val shop = findViewById<ImageView>(R.id.imgTrolley)
        val imgHome = findViewById<ImageView>(R.id.imgHome)

        checkWater()
        displayCoin()

        shop.setOnClickListener {
            startActivity(Intent(this@MainActivity, CoinsActivity::class.java))
            finish()
        }
//        shop.setOnClickListener {
//            startActivity(Intent(this@MainActivity, MainActivity::class.java))
//            finish()
//        }
        imgHome.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomePageActivity::class.java))
            finish()
        }
    }


    private fun CupTime(waterStatus: Any, cup: Any, time: Int) {

        val user = auth.currentUser
        val skin = skin.child(user?.uid!!)
        val hour = SimpleDateFormat("HH").format(Calendar.getInstance().time).toInt()





        skin.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentDate = SimpleDateFormat("DD").format(Calendar.getInstance().time).toInt()
                val skin = snapshot.child("Skin").value.toString()
                val pastDate = Integer.parseInt(snapshot.child("PastDate").value.toString())
                val emptySkin = SkinActivity().Skin1(skin)
                val waterSkin = SkinActivity().Skin2(skin)


                // if date is different, change all to full and havent drink, then set to current
                if (currentDate != pastDate) {
                    secondMethod(cup, waterSkin)
                    val updateDate = mapOf<String,Int>(
                        "PastDate" to currentDate
                    )
                    coin.child(user.uid).updateChildren(updateDate)
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    finish()
                }


                if (hour >= time && waterStatus == "0") {
                    firstMethod(cup, emptySkin, waterSkin)

                }  else if (hour < time){
                    secondMethod(cup, waterSkin)

                } else {
                    thirdMethod(cup, emptySkin)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })

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
        cup7.addValueEventListener(object : ValueEventListener {
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
        val user = auth.currentUser
        val coinz = coin.child(user?.uid!!)


        coinz.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val Coins = snapshot.child("Coins").value.toString().toInt()
                val newValue = Coins + 1
                val addCoin = mapOf<String,Int>(
                    "Coins" to newValue
                )
                coin.child(user?.uid!!).updateChildren(addCoin)
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })


        return update
    }

    private fun displayCoin() {
        val user = auth.currentUser
        val coinz = coin.child(user?.uid!!)
        val tx = findViewById<TextView>(R.id.tvCoinsEarned)

        coinz.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val Coins = Integer.parseInt(snapshot.child("Coins").value.toString())
                tx.text = Coins.toString()

            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })


    }


    private fun firstMethod(cup: Any, emptySkin: Int, waterSkin: Int) {
        val user = auth.currentUser
        val glass1 = findViewById<ImageView>(R.id.cup1)
        val glass2 = findViewById<ImageView>(R.id.cup2)
        val glass3 = findViewById<ImageView>(R.id.cup3)
        val glass4 = findViewById<ImageView>(R.id.cup4)
        val glass5 = findViewById<ImageView>(R.id.cup5)
        val glass6 = findViewById<ImageView>(R.id.cup6)
        val glass7 = findViewById<ImageView>(R.id.cup7)
        val glass8 = findViewById<ImageView>(R.id.cup8)

        if (cup == "1") {
            glass1.setImageResource(waterSkin)
            glass1.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass1.setImageResource(emptySkin)
                cup1.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "2") {
            glass2.setImageResource(waterSkin)
            glass2.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass2.setImageResource(emptySkin)
                cup2.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "3") {
            glass3.setImageResource(waterSkin)
            glass3.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass3.setImageResource(emptySkin)
                cup3.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "4") {
            glass4.setImageResource(waterSkin)
            glass4.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass4.setImageResource(emptySkin)
                cup4.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "5") {
            glass5.setImageResource(waterSkin)
            glass5.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass5.setImageResource(emptySkin)
                cup5.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "6") {
            glass6.setImageResource(waterSkin)
            glass6.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass6.setImageResource(emptySkin)
                cup6.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "7") {
            glass7.setImageResource(waterSkin)
            glass7.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass7.setImageResource(emptySkin)
                cup7.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
        if (cup == "8") {
            glass8.setImageResource(waterSkin)
            glass8.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Drank it.",Toast.LENGTH_SHORT).show()
                updateTo1()
                glass8.setImageResource(emptySkin)
                cup8.child(user?.uid!!).updateChildren(updateTo1())

            }
        }
    }
    private fun secondMethod(cup: Any, waterSkin: Int) {
        val user = auth.currentUser
        val glass1 = findViewById<ImageView>(R.id.cup1)
        val glass2 = findViewById<ImageView>(R.id.cup2)
        val glass3 = findViewById<ImageView>(R.id.cup3)
        val glass4 = findViewById<ImageView>(R.id.cup4)
        val glass5 = findViewById<ImageView>(R.id.cup5)
        val glass6 = findViewById<ImageView>(R.id.cup6)
        val glass7 = findViewById<ImageView>(R.id.cup7)
        val glass8 = findViewById<ImageView>(R.id.cup8)
        val hour = SimpleDateFormat("HH").format(Calendar.getInstance().time).toInt()


        if (cup == "1") {
            glass1.setImageResource(waterSkin)
            glass1.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup1.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "2") {
            glass2.setImageResource(waterSkin)
            glass2.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup2.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "3") {
            glass3.setImageResource(waterSkin)
            glass3.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup3.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "4") {
            glass4.setImageResource(waterSkin)
            glass4.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup4.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "5") {
            glass5.setImageResource(waterSkin)
            glass5.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup5.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "6") {
            glass6.setImageResource(waterSkin)
            glass6.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup6.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "7") {
            glass7.setImageResource(waterSkin)
            glass7.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup7.child(user?.uid!!).updateChildren(updateTo0())
        }
        if (cup == "8") {
            glass8.setImageResource(waterSkin)
            glass8.setOnClickListener {
                Toast.makeText(this@MainActivity, "Locked.", Toast.LENGTH_SHORT).show()
            }
            updateTo0()
            cup8.child(user?.uid!!).updateChildren(updateTo0())
        }
    }
    private fun thirdMethod(cup: Any, emptySkin: Int) {
        val user = auth.currentUser
        val glass1 = findViewById<ImageView>(R.id.cup1)
        val glass2 = findViewById<ImageView>(R.id.cup2)
        val glass3 = findViewById<ImageView>(R.id.cup3)
        val glass4 = findViewById<ImageView>(R.id.cup4)
        val glass5 = findViewById<ImageView>(R.id.cup5)
        val glass6 = findViewById<ImageView>(R.id.cup6)
        val glass7 = findViewById<ImageView>(R.id.cup7)
        val glass8 = findViewById<ImageView>(R.id.cup8)

        if (cup == "1") {
            glass1.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass1.setImageResource(emptySkin)
        }
        if (cup == "2") {
            glass2.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass2.setImageResource(emptySkin)
        }
        if (cup == "3") {
            glass3.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass3.setImageResource(emptySkin)
        }
        if (cup == "4") {
            glass4.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass4.setImageResource(emptySkin)
        }
        if (cup == "5") {
            glass5.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass5.setImageResource(emptySkin)
        }
        if (cup == "6") {
            glass6.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass6.setImageResource(emptySkin)
        }
        if (cup == "7") {
            glass7.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass7.setImageResource(emptySkin)
        }
        if (cup == "8") {
            glass8.setOnClickListener {
                Toast.makeText(this@MainActivity, "You Already Drank it.", Toast.LENGTH_SHORT)
                    .show()
            }
            glass8.setImageResource(emptySkin)
        }
    }

    }

