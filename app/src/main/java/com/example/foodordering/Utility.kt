package com.example.foodordering

import android.content.Context
import android.content.SharedPreferences
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class Utility {
    companion object factory {

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
}