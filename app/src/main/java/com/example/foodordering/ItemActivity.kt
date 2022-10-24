package com.example.foodordering

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_main.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        setOrderBottomVisibility()

        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        var foods = rcvIntent.getSerializableExtra("foods") as ArrayList<Food>
        var food = foods.get(0)

        // test codes---------
        textView.text = food.name
//        imageView.setImageResource(image!!.toInt())


        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutItemOrderBottom, OrderBottomFragment())
        fragTrans.commit()


        imageView.setOnClickListener {
//            var rintent = intent
//            rintent.putExtra("xyz", "wwwwww")
//            setResult(Activity.RESULT_OK, rintent)

            var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
            var flag = sp.getBoolean("hasItem",false)
            var spEdit = sp.edit()
            spEdit.putBoolean("hasItem", !flag)
            spEdit.apply()

            setOrderBottomVisibility()
        }

        //---------------------


    }

    private fun setOrderBottomVisibility() {
        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
            frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
        } else {
            frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
        }
    }



}