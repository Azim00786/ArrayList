package com.example.arraylist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import java.util.Objects

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentListArray = arrayListOf("pramod", "Shubham", "pradeep","Azim","Mustufa","Bipul","Ahmad","Taufik","sana")
        val studentArrayAdapterList = ArrayAdapter(this,android.R.layout.simple_list_item_1 , studentListArray)
        val studentListView= findViewById<ListView>(R.id.studentlistview)

        studentListView.adapter = studentArrayAdapterList
        studentListView.setOnItemClickListener { adapterView, view, i, l ->
            val item=studentListArray[i]
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        }


        val studentArrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1 , studentListArray  )
        val studentGridView= findViewById<GridView>(R.id.studentGridView)

        studentGridView.adapter = studentArrayAdapter
        studentGridView.setOnItemClickListener { adapterView, view, i, l ->
            val item=studentListArray[i]
            Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        }



        var previousSelectedItem = ""
        val studentspinner = ArrayAdapter(this,android.R.layout.simple_list_item_1 , studentListArray)
        val studentListView1= findViewById<Spinner>(R.id.studentspinner)

        studentListView1.adapter = studentspinner
        studentListView1.onItemSelectedListener= object :OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val item=studentListArray[p2]
                Toast.makeText(this@MainActivity, "prev $previousSelectedItem current $item", Toast.LENGTH_SHORT).show()
                previousSelectedItem = item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


//           var num=1
//        for(a in 1..50){
//            studentArray.add("$num")
//            num++
//        }

    }
}