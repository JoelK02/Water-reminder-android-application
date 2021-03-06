package com.firebaseauthdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView

class TodoAdapter(context: Context ,todoList:MutableList<TodoModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itemList = todoList
    private var updateAndDelete: UpdateAndDelete = context as UpdateAndDelete


    override fun getItem(p0: Int): Any {
        return itemList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val UID: String = itemList.get(p0).UID as String
        val itemTextData = itemList.get(p0).itemDataText
        val done: Boolean = itemList.get(p0).done as Boolean

        val view: View
        val viewHolder: ListViewHolder

        if (p1 == null) {
            view = inflater.inflate(R.layout.row_itemlayout, p2, false)
            viewHolder = ListViewHolder(view)
            view.tag = viewHolder

        } else {
            view = p1
            viewHolder = view.tag as ListViewHolder

        }

        viewHolder.textLabel.text = itemTextData
        viewHolder.isDone.isChecked = done

        viewHolder.isDone.setOnClickListener {
            updateAndDelete.modifyItem(UID, !done!!)
        }

        viewHolder.isDeletd.setOnClickListener {
            updateAndDelete.OnItemDelete(UID)
        }

        return view

    }

    private class ListViewHolder(row: View?) {
        val textLabel: TextView = row!!.findViewById(R.id.item_textView) as TextView
        val isDone: CheckBox = row!!.findViewById(R.id.checkbox) as CheckBox
        val isDeletd: ImageButton = row!!.findViewById(R.id.close) as ImageButton

    }
}