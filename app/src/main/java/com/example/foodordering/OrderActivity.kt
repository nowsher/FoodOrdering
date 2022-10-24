package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OrderActivity : AppCompatActivity() {
    lateinit var orderList:ArrayList<Order>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        ///////////////////////////////////////
        orderList = ArrayList<Order>()

    }
}