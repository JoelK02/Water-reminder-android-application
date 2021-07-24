package com.firebaseauthdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class TimeScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_schedule)

        val time1 = findViewById<EditText>(R.id.edtTime1)
        val time2 = findViewById<EditText>(R.id.edtTime2)
        val time3 = findViewById<EditText>(R.id.edtTime3)
        val time4 = findViewById<EditText>(R.id.edtTime4)
        val time5 = findViewById<EditText>(R.id.edtTime5)
        val time6 = findViewById<EditText>(R.id.edtTime6)
        val time7 = findViewById<EditText>(R.id.edtTime7)
        val time8 = findViewById<EditText>(R.id.edtTime8)

    }


}