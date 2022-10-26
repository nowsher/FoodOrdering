package com.example.foodordering

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class OrderBottomFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_order_bottom, container, false)

        var lilearBottom: LinearLayout =
            view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout

        //get list from database
        launch {
            context?.let {
//                var frameLayoutOrderBottom: LinearLayout =
//                    view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout

//                if (checkoutGetAll == null || checkoutGetAll.count() <= 0) {
//                    frameLayoutOrderBottom.visibility = LinearLayout.GONE
//                } else {
                    var checkoutGetAll = CheckoutDatabase(it).getCheckoutDao().getAllCheckout()
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
                                    it.description
                                )
                            )
                        )
                    }

//                    frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//                }

            }
        }

        lilearBottom.setOnClickListener {
//            Toast.makeText(context, "Hi", Toast.LENGTH_LONG).show()

//            if (Utility.getOrderObject().size > 0){

//            }
            val intent = Intent(context, OrderActivity::class.java)
            startActivity(intent)


        }

//        var sharedPref = this.activity?.getSharedPreferences("orderedItems", Context.MODE_PRIVATE)
//        sharedPref?.registerOnSharedPreferenceChangeListener { sharedPreferences, sKey ->
//            var frameLayoutOrderBottom: LinearLayout =
//                view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
//            var frame = frameLayoutOrderBottom.parent as FrameLayout
//            if (sKey.equals("hasItem")) {
//                if (sharedPref.getBoolean(sKey, false)) {
//                    frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//                    frame.visibility = LinearLayout.VISIBLE
//                } else {
//                    frameLayoutOrderBottom.visibility = LinearLayout.GONE
//                    frame.visibility = LinearLayout.GONE
//                }
//            }
//        }

        return view
    }

}