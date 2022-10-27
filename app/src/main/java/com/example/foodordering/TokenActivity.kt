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
        val token1 = rcvIntent.getStringExtra("token1")
        val token2 = rcvIntent.getStringExtra("token2")
        textViewToken.text = token1 + "   ".toString() + token2

        buttonBack.setOnClickListener{
            finish()
        }
    }
}