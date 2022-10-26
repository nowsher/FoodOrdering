package com.example.foodordering

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        setOrderBottomVisibility()

        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        var foodData = rcvIntent.getSerializableExtra("foods") as ArrayList<FoodData>
        var food = foodData.get(0)

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

            var order = OrderData(1,
                5,
                FoodData(1,"chicken",-1,5.5,"")
                )
            Utility.getOrderObject().add(order)
            var orders = Utility.getOrderObject()

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