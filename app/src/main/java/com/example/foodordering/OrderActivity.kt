package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.foodordering.db.Checkout
//import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(){
    lateinit var orderList: ArrayList<OrderData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        ///////////////////////////////////////
        supportActionBar?.setTitle("Order list")

        orderList = Utility.getOrderObject()

        //Show the Fragment on top.
        var fragTrans: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragTrans.add(R.id.frameLayout1, OrderFragment())
        fragTrans.commit()
    }


}