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

        //clear
        Utility.getOrderObject().clear()
        //get list from database and fill local list
        launch {
            context?.let {
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
                                    it.description,
                                    true
                                )
                            )
                        )
                    }


            }
        }

        lilearBottom.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}