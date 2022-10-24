package com.example.foodordering

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        // test codes---------
        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        val image = rcvIntent.getIntExtra("image",-1)
        textView.text = title
        imageView.setImageResource(image!!.toInt())

//        var sp:SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        var spEdit = sp.edit()
//        spEdit.putBoolean("hasItem",true)
//        spEdit.apply()

        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutItemOrderBottom, OrderBottomFragment())
        fragTrans.commit()


//        imageView.setOnClickListener{
//            var rintent = intent
//            rintent.putExtra("xyz", "wwwwww")
//            setResult(Activity.RESULT_OK, rintent)
//            finish()
//        }

        //---------------------



    }

//    override fun onPause() {
//        super.onPause()
//        var rintent = intent
//        rintent.putExtra("xyz", "wwwwww")
//        setResult(Activity.RESULT_OK, rintent)
//    }
//



}