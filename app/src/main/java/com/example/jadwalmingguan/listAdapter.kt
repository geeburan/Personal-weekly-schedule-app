package com.example.jadwalmingguan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class listAdapter(context: Context, dataArrayList: ArrayList<listData?>?) :
    ArrayAdapter<listData?>(context, R.layout.hari, dataArrayList!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.hari, parent, false)
        }

        val listName = view?.findViewById<TextView>(R.id.listHari)
        val listDesc = view?.findViewById<TextView>(R.id.dayList)

        if (listData != null) {
            listName?.text = listData.name
            listDesc?.text = listData.desc
        }

        return view!!
    }
}
