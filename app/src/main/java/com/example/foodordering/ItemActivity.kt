package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        /////////////////////////////////////
        val rcvIntent = intent
        val title = rcvIntent.getStringExtra("name")
        val image = rcvIntent.getIntExtra("image",-1)
        textView.text = title
        imageView.setImageResource(image!!.toInt())

    }
}