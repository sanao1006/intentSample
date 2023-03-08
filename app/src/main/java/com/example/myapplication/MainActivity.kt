package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

        lvMenu.onItemClickListener = ListItemClickListener()

    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val item = parent!!.getItemAtPosition(position) as MutableMap<String, String>
            val menuName = item["name"]
            val menuPrice = item["price"]
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)
            startActivity(intent2MenuThanks)

        }
    }
}