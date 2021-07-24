package com.firebaseauthdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*


class RegisterActivity : AppCompatActivity() {

    lateinit var  auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var  reference: DatabaseReference
    private lateinit var  cup1: DatabaseReference
    private lateinit var  cup2: DatabaseReference
    private lateinit var  cup3: DatabaseReference
    private lateinit var  cup4: DatabaseReference
    private lateinit var  cup5: DatabaseReference
    private lateinit var  cup6: DatabaseReference
    private lateinit var  cup7: DatabaseReference
    private lateinit var  cup8: DatabaseReference

    private lateinit var  skin1: DatabaseReference
    private lateinit var  skin2: DatabaseReference
    private lateinit var  skin3: DatabaseReference
    private lateinit var  skin4: DatabaseReference
    private lateinit var  skin5: DatabaseReference
    private lateinit var  skin6: DatabaseReference


    lateinit var btn_register: Button
    lateinit var et_register_email: EditText
    lateinit var et_register_password: EditText
    lateinit var et_register_username: EditText
    lateinit var tv_login: TextView
    var i = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://fir-authdemo-5224c-default-rtdb.asia-southeast1.firebasedatabase.app/")
        reference = database.getReference("Users")

        cup1 = database.getReference("Cup1")
        cup2 = database.getReference("Cup2")
        cup3 = database.getReference("Cup3")
        cup4 = database.getReference("Cup4")
        cup5 = database.getReference("Cup5")
        cup6 = database.getReference("Cup6")
        cup7 = database.getReference("Cup7")
        cup8 = database.getReference("Cup8")

        skin1 = database.getReference("Skin1")
        skin2 = database.getReference("Skin2")
        skin3 = database.getReference("Skin3")
        skin4 = database.getReference("Skin4")
        skin5 = database.getReference("Skin5")
        skin6 = database.getReference("Skin6")

        btn_register = findViewById(R.id.btn_register)
        et_register_email = findViewById(R.id.et_register_email)
        et_register_password = findViewById(R.id.et_register_password)
        et_register_username = findViewById(R.id.et_register_username)
        tv_login = findViewById(R.id.tv_login)

        tv_login.setOnClickListener {
            onBackPressed()
        }

        btn_register.setOnClickListener {
            // to check the presence of the empty email
            // trim = cutting the empty space in email
            // if no email  then display short toast
            when {

                TextUtils.isEmpty(et_register_username.text.toString(). trim{it <= ' '}) ->{
                    Toast.makeText(this@RegisterActivity, "Please enter username",Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(et_register_email.text.toString(). trim{it <= ' '}) ->{
                    Toast.makeText(this@RegisterActivity, "Please enter email.",Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(et_register_password.text.toString(). trim{it <= ' '}) ->{
                    Toast.makeText(this@RegisterActivity, "Please enter password.",Toast.LENGTH_SHORT).show()
                }


                // if username, email and password checked and not empty
                else ->{
                    val email: String = et_register_email.text.toString(). trim{it <= ' '}
                    val password: String = et_register_password.text.toString(). trim{it <= ' '}


                    // Create an instance and create a register a suer with email and password
                    // OnCompleteListener are mutiple overloads, task is one of the overload
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                        OnCompleteListener <AuthResult>{ task ->

                            //If the registration is successfully done
                            if (task.isSuccessful){

                                // Firebase registered user, create a firebase for user
                                // task will give result and user inside "result"
                                val firebaseUser :FirebaseUser= task.result!!.user!!

                                sendData()
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You were registered successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                // sent user to from RegisterActivity to MainActivity
                                // Android API only accept java so use class.java
                                val intent = Intent(this@RegisterActivity, MainActivity::class.java)

                                // getting rid of extra layers of activities we had
                                // e.g. from Register to Login, Login to Register wil cause lot of instance so need to get rid of these
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("userid",firebaseUser.uid)
                                intent.putExtra("emailid",email)
                                startActivity(intent)
                                finish() // get rid of other activities so that only left main activity
                                // even if user press back key, they cant get back to register/login activity, instead it will close apps
                                // if not, user can press back key to return the previous page

                            }else{

                                //If the registering is not successful then show error message.
                                Toast.makeText(this@RegisterActivity,task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
        }

    }

    private fun sendData() {
        val date = SimpleDateFormat("DD").format(Calendar.getInstance().time).toInt()
        val username = et_register_username.text.toString().trim()
        val email = et_register_email.text.toString().trim()
        val password = et_register_password.text.toString().trim()


        val currentUser = auth.currentUser
        val currentUserDV= reference.child(currentUser?.uid!!)
        currentUserDV.child("Username").setValue(username)
        currentUserDV.child("Email").setValue(email)
        currentUserDV.child("Password").setValue(password)
        currentUserDV.child("Skin").setValue("0")
        currentUserDV.child("Coins").setValue(0)
        currentUserDV.child("PastDate").setValue(date)

        val cup1 = cup1.child(currentUser?.uid!!)
        val cup2 = cup2.child(currentUser?.uid!!)
        val cup3 = cup3.child(currentUser?.uid!!)
        val cup4 = cup4.child(currentUser?.uid!!)
        val cup5 = cup5.child(currentUser?.uid!!)
        val cup6 = cup6.child(currentUser?.uid!!)
        val cup7 = cup7.child(currentUser?.uid!!)
        val cup8 = cup8.child(currentUser?.uid!!)

        val skin1 = skin1.child(currentUser?.uid!!)
        val skin2 = skin2.child(currentUser?.uid!!)
        val skin3 = skin3.child(currentUser?.uid!!)
        val skin4 = skin4.child(currentUser?.uid!!)
        val skin5 = skin5.child(currentUser?.uid!!)
        val skin6 = skin6.child(currentUser?.uid!!)


        cup1.child("Data").setValue("0")
        cup2.child("Data").setValue("0")
        cup3.child("Data").setValue("0")
        cup4.child("Data").setValue("0")
        cup5.child("Data").setValue("0")
        cup6.child("Data").setValue("0")
        cup7.child("Data").setValue("0")
        cup8.child("Data").setValue("0")

        skin1.child("Status").setValue("0")
        skin2.child("Status").setValue("0")
        skin3.child("Status").setValue("0")
        skin4.child("Status").setValue("0")
        skin5.child("Status").setValue("0")
        skin6.child("Status").setValue("0")



    }

}




