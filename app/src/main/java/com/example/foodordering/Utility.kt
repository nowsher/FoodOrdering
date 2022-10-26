package com.example.foodordering

class Utility {

    //need to check singleton
    companion object Factory {
        private var orderList: ArrayList<OrderData> = ArrayList<OrderData>()

        fun getOrderObject(): ArrayList<OrderData> {
            return orderList as ArrayList<OrderData>
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

}