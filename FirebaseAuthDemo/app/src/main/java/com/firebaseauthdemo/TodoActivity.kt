package com.firebaseauthdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class TodoActivity : AppCompatActivity(), UpdateAndDelete {

    lateinit var auth: FirebaseAuth
    lateinit var database : DatabaseReference
    var toDoList : MutableList<TodoModel>? = null
    lateinit var adapter: TodoAdapter
    private var listViewItem : ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo)
        val user = auth.currentUser
        val fab = findViewById<View>(R.id.item_fab) as FloatingActionButton
        listViewItem = findViewById<ListView>(R.id.item_listView)


        database = FirebaseDatabase.getInstance().reference

        fab.setOnClickListener{ View ->

            val alertDialog = AlertDialog.Builder(this)
            val textEditText = EditText(this)
            alertDialog.setMessage("Add To-do Item")
            alertDialog.setTitle("Enter To-do Item")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add"){dialog, i ->
                val todoItemData = TodoModel.createList()
                todoItemData.itemDataText = textEditText.text.toString()
                todoItemData.done = false

                val newItemData = database.child("todo").child(user?.uid!!).push()
                todoItemData.UID = newItemData.key

                newItemData.setValue(todoItemData)

                dialog.dismiss()
                Toast.makeText(this,"item saved",Toast.LENGTH_LONG).show()
            }
            alertDialog.show()
        }

        toDoList = mutableListOf<TodoModel>()

        adapter = TodoAdapter(this,toDoList!!)
        listViewItem!!.adapter = adapter
        database.child("todo").child(user?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                toDoList!!.clear()
                addItemToList(snapshot)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"No Item Added", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun addItemToList(snapshot: DataSnapshot) {

        val items = snapshot.children.iterator()

        while (items.hasNext()){

            val todoIndexedValue = items.next()


            val toDoItemData = TodoModel.createList()
            var done = todoIndexedValue.child("done").value as Boolean
            var itemDataText = todoIndexedValue.child("itemDataText").value as String


            toDoItemData.UID = todoIndexedValue.key
            toDoItemData.done = done
            toDoItemData.itemDataText = itemDataText
            toDoList!!.add(toDoItemData)

        }


        adapter.notifyDataSetChanged()
    }


    override fun modifyItem(itemUID: String, isDone: Boolean) {
        val user = auth.currentUser
        val itemReference = database.child("todo").child(user?.uid!!).child(itemUID)
        itemReference.child("done").setValue(isDone)
    }

    override fun OnItemDelete(itemUID: String) {
        val user = auth.currentUser
        val itemReference = database.child("todo").child(user?.uid!!).child(itemUID)
        itemReference.removeValue()
        adapter.notifyDataSetChanged()
    }
}