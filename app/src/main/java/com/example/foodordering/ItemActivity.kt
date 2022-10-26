package com.example.foodordering

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.coroutines.CoroutineScope


class ItemActivity : AppCompatActivity() {
//    val fooditem = arrayOf<String>("Chicken","Breakfast","Beverages","Desserts & Shakes",
//        "Chicken & Fish Sandwiche","Bakery")
//    val description = arrayOf<String>(
//        "Price: $1.81",
//        "Price: $1.81",
//        "Price: $1.81",
//        "Price: $1.81",
//        "Price: $1.81",
//        "Price: $1.81"
//    )
//
//    val imageId = arrayOf<Int>(
//        R.drawable.chicken,
//        R.drawable.breakfast,
//        R.drawable.beverages,
//        R.drawable.desserts,
//        R.drawable.chickenfishsandwiches,
//        R.drawable.bakery
//
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        setOrderBottomVisibility()

        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        var foodList = rcvIntent.getSerializableExtra("foods") as ArrayList<FoodData>
//        var food = foodList.get(0)

        // test codes---------
//        textView.text = food.name
////        imageView.setImageResource(image!!.toInt())
//
//
//        var fragManager = supportFragmentManager
//        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
//        fragTrans.add(R.id.frameLayoutItemOrderBottom, OrderBottomFragment())
//        fragTrans.commit()
//
//
//        imageView.setOnClickListener {
////            var rintent = intent
////            rintent.putExtra("xyz", "wwwwww")
////            setResult(Activity.RESULT_OK, rintent)
//
//            var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//            var flag = sp.getBoolean("hasItem",false)
//            var spEdit = sp.edit()
//            spEdit.putBoolean("hasItem", !flag)
//            spEdit.apply()
//
//            var order = OrderData(1,
//                5,
//                FoodData(1,"chicken",-1,5.5,"")
//                )
//            Utility.getOrderObject().add(order)
//            var orders = Utility.getOrderObject()
//
//
//            setOrderBottomVisibility()
//        }

        //---------------------
        //kallol
        val myListAdapter = MyListAdapter(this, foodList)
        listView.adapter = myListAdapter

        setOrderBottomVisibility()

//
//        listView.setOnItemClickListener(){adapterView, view, position, id ->
//            val itemAtPos = adapterView.getItemAtPosition(position)
//            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//            Toast.makeText(this, "Click on item at $itemAtPos its item $itemIdAtPos", Toast.LENGTH_LONG).show()
//        }


        var resultItems = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        }

    }

    fun setOrderBottomVisibility() {
        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
            frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
        } else {
            frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
        }
    }

    fun runCoroutineScope() {

    }

    fun setSPHasBag(value: Boolean) {
        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
        var flag = sp.getBoolean("hasItem", false)
        if (value != flag) {
            var spEdit = sp.edit()
            spEdit.putBoolean("hasItem", !value)
            spEdit.apply()
        }
    }


}