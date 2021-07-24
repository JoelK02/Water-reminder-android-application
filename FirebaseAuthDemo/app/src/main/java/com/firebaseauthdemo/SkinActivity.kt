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

        } else if (skin == "1") {
            temp = R.drawable.muscle_cup

        } else if (skin == "2") {
            temp = R.drawable.tigger_cup

        } else if (skin == "3") {
            temp = R.drawable.sloth_mug

        } else if (skin == "4") {
            temp = R.drawable.hero_mug

        } else if (skin == "5") {
            temp = R.drawable.gold_cup

        } else if (skin == "6") {
            temp = R.drawable.mickey_cup

        }

        return temp
    }
    fun Skin2(skin: String): Int {
        var temp = 0
        if (skin == "0") {
            temp = R.drawable.glass_water
        } else if (skin == "1") {
            temp = R.drawable.muscle_cup_water

        } else if (skin == "2") {
            temp = R.drawable.tigger_cup_water

        } else if (skin == "3") {
            temp = R.drawable.sloth_mug_water

        } else if (skin == "4") {
            temp = R.drawable.hero_mug_water

        } else if (skin == "5") {
            temp = R.drawable.gold_cup_water

        } else if (skin == "6") {
            temp = R.drawable.mickey_cup_water

        }
        return temp
    }


}