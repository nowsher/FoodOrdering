package com.example.foodordering

import android.content.Context
import android.content.SharedPreferences
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.Handler

class Utility {

    //need to check singleton
    companion object Factory {
        private var orderList: ArrayList<OrderData> = ArrayList<OrderData>()

        fun getOrderObject(): ArrayList<OrderData> {
            return orderList as ArrayList<OrderData>
        }

//        fun updateOrderStatus(frameLayout:FrameLayout,context:Context) {
////            android.os.Handler().postDelayed({
////
////            }, 2000)
//
//            CoroutineScope(Dispatchers.IO).launch {
//                var checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
//                if (checkoutGetAll != null && checkoutGetAll.size > 0) {
//                    frameLayout.visibility = LinearLayout.VISIBLE
//                }else{
//                    frameLayout.visibility = LinearLayout.GONE
//                }
//            }
//
//        }

        fun fillOrderData(context: Context?) {
            Utility.getOrderObject().clear()
            CoroutineScope(Dispatchers.IO).launch {
                var checkoutGetAll = CheckoutDatabase(context!!).getCheckoutDao().getAllCheckout()
                checkoutGetAll.forEach {

                    Utility.getOrderObject().add(
                        OrderData(
                            it.id,
                            it.quantity,
                            FoodData(
                                it.foodid,
                                it.foodname,
                                it.foodimage,
                                it.price,
                                it.description,
                                true
                            )
                        )
                    )
                }

            }
        }


    }


//        fun setOrderBotomVisibility() {
//            var sharedPref = getSharedPreferences("orderedItems", Context.MODE_PRIVATE)
//            sharedPref.registerOnSharedPreferenceChangeListener { sharedPreferences, sKey ->
//                var frameLayoutOrderBottom: LinearLayout =
//                    view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
//
//                if (sKey.equals("hasItem")) {
//                    if (sharedPref.getBoolean(sKey, true)) {
//                        frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//                    } else {
//                        frameLayoutOrderBottom.visibility = LinearLayout.INVISIBLE
//                    }
//                }
//            }
//        }

//        private fun setOrderBottomVisibility() {
//            var sp: SharedPreferences = getSharedPreferences("orderedItems",
//                AppCompatActivity.MODE_PRIVATE
//            )
//            if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//                frameLayoutMainOrderBottom.visibility = LinearLayout.VISIBLE
//            } else {
//                frameLayoutMainOrderBottom.visibility = LinearLayout.GONE
//            }
//        }


}