package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class TimeScheduleActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_time_schedule)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser


        cup1 = database.getReference().child("Cup1").child(user?.uid!!)
        cup2 = database.getReference().child("Cup2").child(user.uid)
        cup3 = database.getReference().child("Cup3").child(user.uid)
        cup4 = database.getReference().child("Cup4").child(user.uid)
        cup5 = database.getReference().child("Cup5").child(user.uid)
        cup6 = database.getReference().child("Cup6").child(user.uid)
        cup7 = database.getReference().child("Cup7").child(user.uid)
        cup8 = database.getReference().child("Cup8").child(user.uid)

        val changetime1 = findViewById<ImageView>(R.id.img_exchange1)
        val changetime2 = findViewById<ImageView>(R.id.img_exchange2)
        val changetime3 = findViewById<ImageView>(R.id.img_exchange3)
        val changetime4 = findViewById<ImageView>(R.id.img_exchange4)
        val changetime5 = findViewById<ImageView>(R.id.img_exchange5)
        val changetime6 = findViewById<ImageView>(R.id.img_exchange6)
        val changetime7 = findViewById<ImageView>(R.id.img_exchange7)
        val changetime8 = findViewById<ImageView>(R.id.img_exchange8)

        val time1 = findViewById<TextView>(R.id.edtTime1)
        val time2 = findViewById<TextView>(R.id.edtTime2)
        val time3 = findViewById<TextView>(R.id.edtTime3)
        val time4 = findViewById<TextView>(R.id.edtTime4)
        val time5 = findViewById<TextView>(R.id.edtTime5)
        val time6 = findViewById<TextView>(R.id.edtTime6)
        val time7 = findViewById<TextView>(R.id.edtTime7)
        val time8 = findViewById<TextView>(R.id.edtTime8)
        val returnPage = findViewById<ImageView>(R.id.returnIcon)

        returnPage.setOnClickListener {
            startActivity(Intent(this@TimeScheduleActivity, MainActivity::class.java))
            finish()
        }



        changetime1.setOnClickListener {

            cup1.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 8) {
                        val update = mapOf<String,Int>(
                            "Time" to 7
                        )
                        cup1.updateChildren(update)
                    }
                    if (time == 7) {
                        val update = mapOf<String,Int>(
                            "Time" to 8
                        )
                        cup1.updateChildren(update)
                    }

                    }

                override fun onCancelled(error: DatabaseError) {}
            })

        }
        changetime2.setOnClickListener {

            cup2.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 9) {
                        val update = mapOf<String,Int>(
                            "Time" to 10
                        )
                        cup2.updateChildren(update)
                    }
                    if (time == 10) {
                        val update = mapOf<String,Int>(
                            "Time" to 9
                        )
                        cup2.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime3.setOnClickListener {

            cup3.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 11) {
                        val update = mapOf<String,Int>(
                            "Time" to 12
                        )
                        cup3.updateChildren(update)
                    }
                    if (time == 12) {
                        val update = mapOf<String,Int>(
                            "Time" to 11
                        )
                        cup3.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime4.setOnClickListener {

            cup4.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 13) {
                        val update = mapOf<String,Int>(
                            "Time" to 14
                        )
                        cup4.updateChildren(update)
                    }
                    if (time == 14) {
                        val update = mapOf<String,Int>(
                            "Time" to 13
                        )
                        cup4.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime5.setOnClickListener {

            cup5.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 15) {
                        val update = mapOf<String,Int>(
                            "Time" to 16
                        )
                        cup5.updateChildren(update)
                    }
                    if (time == 16) {
                        val update = mapOf<String,Int>(
                            "Time" to 15
                        )
                        cup5.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime6.setOnClickListener {

            cup6.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 17) {
                        val update = mapOf<String,Int>(
                            "Time" to 18
                        )
                        cup6.updateChildren(update)
                    }
                    if (time == 18) {
                        val update = mapOf<String,Int>(
                            "Time" to 17
                        )
                        cup6.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime7.setOnClickListener {

            cup7.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 19) {
                        val update = mapOf<String,Int>(
                            "Time" to 20
                        )
                        cup7.updateChildren(update)
                    }
                    if (time == 20) {
                        val update = mapOf<String,Int>(
                            "Time" to 19
                        )
                        cup7.updateChildren(update)
                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        changetime8.setOnClickListener {

            cup8.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val time = snapshot.child("Time").value.toString().toInt()
                    if (time == 21) {
                        val update = mapOf<String,Int>(
                            "Time" to 22
                        )
                        cup8.updateChildren(update)

                    }
                    if (time == 22) {
                        val update = mapOf<String,Int>(
                            "Time" to 21
                        )
                        cup8.updateChildren(update)

                    }

                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        setTime()


    }

    fun setTime() {

        val time1 = findViewById<TextView>(R.id.edtTime1)
        val time2 = findViewById<TextView>(R.id.edtTime2)
        val time3 = findViewById<TextView>(R.id.edtTime3)
        val time4 = findViewById<TextView>(R.id.edtTime4)
        val time5 = findViewById<TextView>(R.id.edtTime5)
        val time6 = findViewById<TextView>(R.id.edtTime6)
        val time7 = findViewById<TextView>(R.id.edtTime7)
        val time8 = findViewById<TextView>(R.id.edtTime8)

        cup1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val time = snapshot.child("Time").value.toString().toInt()
                time1.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val time = snapshot.child("Time").value.toString().toInt()
                time2.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val tv_am3 = findViewById<TextView>(R.id.tv_am3)
                val time = snapshot.child("Time").value.toString().toInt()
                if (time == 12){
                    tv_am3.text = "pm"
                } else {
                    tv_am3.text = "am"
                }
                time3.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var time = snapshot.child("Time").value.toString().toInt()
                time -= 12
                time4.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var time = snapshot.child("Time").value.toString().toInt()
                time -= 12
                time5.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var time = snapshot.child("Time").value.toString().toInt()
                time -= 12
                time6.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var time = snapshot.child("Time").value.toString().toInt()
                time -= 12
                time7.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        cup8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var time = snapshot.child("Time").value.toString().toInt()
                time -= 12
                time8.text = time.toString()
            }
            override fun onCancelled(error: DatabaseError) {}
        })

    }

}