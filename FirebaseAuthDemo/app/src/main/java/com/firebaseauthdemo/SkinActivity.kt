package com.firebaseauthdemo

import android.app.Activity
import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference

class SkinActivity {

    fun Skin1(skin: String): Int {
        var temp = 0
        if (skin == "0") {
            temp = R.drawable.empty_glass
        }
        return temp
    }
    fun Skin2(skin: String): Int {
        var temp = 0
        if (skin == "0") {
            temp = R.drawable.glass_water
        }
        return temp
    }


}