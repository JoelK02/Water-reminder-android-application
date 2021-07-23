package com.firebaseauthdemo

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CoinsActivity: AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var  skin1: DatabaseReference
    private lateinit var  skin2: DatabaseReference
    private lateinit var  skin3: DatabaseReference
    private lateinit var  skin4: DatabaseReference
    private lateinit var  skin5: DatabaseReference
    private lateinit var  skin6: DatabaseReference
    private lateinit var  coin: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin_shop)



        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        skin1 = database.getReference().child("Skin1").child(user?.uid!!)
        skin2 = database.getReference().child("Skin2").child(user.uid)
        skin3 = database.getReference().child("Skin3").child(user.uid)
        skin4 = database.getReference().child("Skin4").child(user.uid)
        skin5 = database.getReference().child("Skin5").child(user.uid)
        skin6 = database.getReference().child("Skin6").child(user.uid)
        coin = database.getReference().child("Users").child(user.uid)

        val returnPage = findViewById<ImageView>(R.id.imgReturnPage)

        returnPage.setOnClickListener {
            startActivity(Intent(this@CoinsActivity, MainActivity::class.java))
            finish()
        }

        displayCoin()
        Method()


    }

    private fun check(status: String, skin: String) {

        val builder = AlertDialog.Builder(this)
        if (status == "0") {

            // havent unlock, check if enuf coin, if yes, ask buy, if no then alert user

            builder.setTitle("Confirmation")
            builder.setMessage("Do you want to buy this skin?")
            builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->

                coin.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val coins = snapshot.child("Coins").value.toString().toInt()
                        checkEnoughCoins(skin, coins)

                    }
                    override fun onCancelled(error: DatabaseError) {
                        println("Error")
                    }
                })

            }
            builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        } else {
            coin.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val currentSkin = snapshot.child("Skin").value.toString()

                    if (currentSkin == skin){
                        Toast.makeText(this@CoinsActivity, "This is skin already set", Toast.LENGTH_SHORT).show()
                    } else {
                        builder.setTitle("Confirmation")
                        if (skin != "0") {
                            builder.setMessage("You already unlocked this skin, do you want to set it as current skin?")
                        } else {
                            builder.setMessage("Set as default skin?")
                        }

                        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->

                            changeSkin(skin)

                        }
                        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

                        }
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
            // user already unlock, ask if want to set

        }
    }

    private fun changeSkin(skin: String) {

        val update = mapOf<String,String>(
            "Skin" to skin
        )
        coin.updateChildren(update)

        Toast.makeText(this@CoinsActivity, "You Changed Skins", Toast.LENGTH_SHORT).show()
    }


    private fun checkEnoughCoins(skin: String, coins: Int) {
        if (skin == "1" && coins >= 40) {
            val cost = 40
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin1.updateChildren(update)
        } else if (skin == "2" && coins >= 60) {
            val cost = 60
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin2.updateChildren(update)
        } else if (skin == "3" && coins >= 80) {
            val cost = 80
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin3.updateChildren(update)
        } else if (skin == "4" && coins >= 150) {
            val cost = 150
            //prompt are you sure
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin4.updateChildren(update)
        } else if (skin == "5" && coins >= 170) {
            val cost = 170
            //prompt are you sure
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin5.updateChildren(update)
        } else if (skin == "6" && coins >= 250) {
            val cost = 250
            //prompt are you sure
            buySkin(coins, cost)
            val update = mapOf<String,String>(
                "Status" to "1"
            )
            skin6.updateChildren(update)
        } else {
            Toast.makeText(this@CoinsActivity, "You do not have enough coins", Toast.LENGTH_SHORT).show()
        }

    }

    private fun buySkin(coins: Int, cost: Int) {
        val change = coins - cost
        val update = mapOf<String,Int>(
            "Coins" to change
        )
        coin.updateChildren(update)


        Toast.makeText(this@CoinsActivity, "You Bought A Skin", Toast.LENGTH_SHORT).show()
    }

    private fun Method() {

        val defaultSkin = findViewById<ImageView>(R.id.defaultSkin)
        val firstSkin = findViewById<ImageView>(R.id.skinCup1)
        val secondSkin = findViewById<ImageView>(R.id.skinCup2)
        val thirdSkin = findViewById<ImageView>(R.id.skinCup3)
        val fourthSkin = findViewById<ImageView>(R.id.skinCup4)
        val fifthSkin= findViewById<ImageView>(R.id.skinCup5)
        val sixthSkin = findViewById<ImageView>(R.id.skinCup6)
        val builder = AlertDialog.Builder(this)

        defaultSkin.setOnClickListener {
            check("1", "0")
        }
        firstSkin.setOnClickListener {
            skin1.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "1"
                    val status = snapshot.child("Status").value.toString()

                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
        secondSkin.setOnClickListener {
            skin2.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "2"
                    val status = snapshot.child("Status").value.toString()
                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
        thirdSkin.setOnClickListener {
            skin3.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "3"
                    val status = snapshot.child("Status").value.toString()
                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
        fourthSkin.setOnClickListener {
            skin4.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "4"
                    val status = snapshot.child("Status").value.toString()
                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
        fifthSkin.setOnClickListener {
            skin5.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "5"
                    val status = snapshot.child("Status").value.toString()
                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
        sixthSkin.setOnClickListener {
            skin6.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val skin = "6"
                    val status = snapshot.child("Status").value.toString()
                    check(status, skin)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
    }

    private fun displayCoin() {
        val tx = findViewById<TextView>(R.id.tv_render_coins)

        coin.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val Coins = snapshot.child("Coins").value.toString()
                tx.text = Coins

            }
            override fun onCancelled(error: DatabaseError) {
                println("Error")
            }
        })
    }

}