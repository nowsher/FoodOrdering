package com.example.foodordering

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        supportActionBar?.setTitle("Foods available")

        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        var foodList = rcvIntent.getSerializableExtra("foods") as ArrayList<FoodData>
        //updated "isBagged" status if already selected.
        Utility.getOrderObject().forEach{
            var savedId = it.foodData.id
            var food = foodList.find {
                savedId == it.id
            }
            if (food != null){
                food.isBagged = true
            }
        }
        val adapterItem = AdapterItem(this, foodList)
        listView.adapter = adapterItem


        //Place bottom order fragment
        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutItemOrderBottom, OrderBottomFragment())
        fragTrans.commit()

        updateOrderView(this)
    }


    fun updateOrderView(context: Context) {
        var checkoutGetAll: List<Checkout>? = null
        CoroutineScope(Dispatchers.IO).launch {
            checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
        }
        for (i in 1..10) {
            Thread.sleep(100)
            if (checkoutGetAll != null) {
                if (checkoutGetAll != null && checkoutGetAll!!.size > 0) {
                    frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
                } else {
                    frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
                }
                break
            }
        }

//    fun setOrderBottomVisibility() {
//        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//            frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
//        } else {
//            frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
//        }
//    }

//    fun setSharedPPreferenceHasBag() {
//        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        var flag = sp.getBoolean("hasItem", false)
//        if (value != flag) {
//            var spEdit = sp.edit()
//            spEdit.putBoolean("hasItem", !value)
//            spEdit.apply()
//        }
//    }

//    fun setOrderBottomVisibility() {
//        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//            frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
//        } else {
//            frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
//        }
//    }



//        fun calculateDocs() = CoroutineScope(Dispatchers.IO).launch {
//            lateinit var checkoutGetAll:List<Checkout>
//            val valueVariable = try {
//                checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
//            } catch (e: Exception) {
//
//            }
//            if (checkoutGetAll != null && checkoutGetAll.size > 0) {
//                frameLayoutItemOrderBottom.visibility = LinearLayout.VISIBLE
//            } else {
//                frameLayoutItemOrderBottom.visibility = LinearLayout.GONE
//            }
//        }
    }

}