package com.firebaseauthdemo

import android.database.sqlite.SQLiteDoneException

interface UpdateAndDelete{

    fun modifyItem(itemUID :String, isDone : Boolean)
    fun OnItemDelete(itemUID :String)
}