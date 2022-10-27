package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_token.*

class TokenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        supportActionBar?.setTitle("Order token")

        val rcvIntent = intent
        val token = rcvIntent.getStringExtra("token")
        textViewToken.text = token.substring(0,2) + "   ".toString() + token.substring(2,4)

        buttonBack.setOnClickListener{
            finish()
        }
        buttonConfirm.setOnClickListener{
            Utility.ClearOrderData(this)
            finish()
        }
    }
}