package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val menulist: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf<String, String>("name" to "ハンバーグ", "price" to "850円")
        menulist.add(menu)
        menu = mutableMapOf<String, String>("name" to "から揚げ", "price" to "500円")
        menulist.add(menu)
        menu = mutableMapOf<String, String>("name" to "ラーメン", "price" to "700円")
        menulist.add(menu)

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(
            this@MainActivity,
            menulist,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        lvMenu.adapter = adapter

    }
}