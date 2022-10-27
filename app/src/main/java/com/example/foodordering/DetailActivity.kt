package com.example.foodordering

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Double

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setTitle("Foods detail")

        val rcvIntent = intent
        //val foodImg = rcvIntent.getIntExtra()
        val id = rcvIntent.getIntExtra("id", -1)
        val name = rcvIntent.getStringExtra("name")
        val imageid = rcvIntent.getIntExtra("imageid", -1)
        val priceStr = rcvIntent.getStringExtra("price")
        val price = Double.parseDouble(priceStr)
        val description = rcvIntent.getStringExtra("description")

        detImg.setImageResource(imageid)
        tv_Name_val.text = name
        tv_price_val.text = "$".toString() + price.toString()
        tv_des_val.text = description


        btn_add_bag.setOnClickListener() {

            var food = Utility.getOrderObject().find {
                id == it.id
            }
            if (food == null) {
                //updated memory list
                Utility.getOrderObject().add(
                    OrderData(
                        -1,
                        -1,
                        FoodData(id, name, imageid, price, description)
                    )
                )
            }
            //updated database entry
            CoroutineScope(Dispatchers.IO).launch {
                var x = CheckoutDatabase(btn_add_bag.context).getCheckoutDao()
                    .addCheckout(
                        Checkout(
                            1,
                            name,
                            id,
                            imageid,
                            price,
                            "",
                            Utility.getToken()
                        )
                    )
            }
            finish()
        }


    }
}