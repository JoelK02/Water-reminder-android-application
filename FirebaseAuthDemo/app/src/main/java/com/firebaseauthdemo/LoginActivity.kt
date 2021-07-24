package com.firebaseauthdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    lateinit var tv_register: TextView
    lateinit var btn_login: Button
    lateinit var et_login_email: EditText
    lateinit var et_login_password: EditText
    lateinit var tv_forgot_password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // if user login ady without logout, next time it will return to MainActivity but not Login Activity
        // .currentUser = to get the current user
        // if no user sign in , then .currentUser will return null
        val currentuser = FirebaseAuth.getInstance().currentUser
        if (currentuser == null) {
            // user is sign in

            //}

            tv_register = findViewById(R.id.tv_register)
            btn_login = findViewById(R.id.btn_login)
            et_login_email = findViewById(R.id.et_login_email)
            et_login_password = findViewById(R.id.et_login_password)
            tv_forgot_password = findViewById(R.id.tv_forgot_password)


            tv_register.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }

            tv_forgot_password.setOnClickListener {
                startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            }

            btn_login.setOnClickListener {
                // to check the presence of the empty email
                // trim = cutting the empty space in email
                // if no email  then display short toast
                when {
                    TextUtils.isEmpty(et_login_email.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            this@LoginActivity,
                            "Please enter email.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    TextUtils.isEmpty(et_login_password.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            this@LoginActivity,
                            "Please enter password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // if email and password checked and not empty
                    // oso trim the blank space in email/password
                    else -> {
                        val email: String = et_login_email.text.toString().trim { it <= ' ' }
                        val password: String = et_login_password.text.toString().trim { it <= ' ' }

                        // Create an instance and create a register a suer with email and password
                        // OnCompleteListener are mutiple overloads, task is one of the overload
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->

                                //If the registration is successfully done
                                if (task.isSuccessful) {

                                    // Firebase registered user, create a firebase for user
                                    // task will give result and user inside "result"
                                    val firebaseUser: FirebaseUser = task.result!!.user!!
                                    Toast.makeText(
                                        this@LoginActivity,
                                        "You were logged in successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    // sent user to from RegisterActivity to HomePageActivity
                                    // Android API only accept java so use class.java
                                    val intent =
                                        Intent(this@LoginActivity, HomePageActivity::class.java)

                                    // getting rid of extra layers of activities we had
                                    // e.g. from Register to Login, Login to Register wil cause lot of instance so need to get rid of these
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra(
                                        "userid",
                                        FirebaseAuth.getInstance().currentUser!!.uid
                                    )
                                    intent.putExtra("emailid", email)
                                    startActivity(intent)
                                    finish() // get rid of other activities so that only left main activity
                                    // even if user press back key, they cant get back to register/login activity, instead it will close apps
                                    // if not, user can press back key to return the previous page

                                } else {

                                    //If the login is not successful then show error message.
                                    Toast.makeText(
                                        this@LoginActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }


                    }
                }


            }


        } else {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}