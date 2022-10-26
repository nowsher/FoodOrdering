package com.example.foodordering

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyListAdapter(private val context: Activity, val foods: ArrayList<FoodData>) :
    ArrayAdapter<FoodData>(context, R.layout.item_list, foods) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        val priceText = rowView.findViewById(R.id.price) as TextView
        val linLayout = rowView.findViewById(R.id.linearLayout1) as LinearLayout
        val imageBag = rowView.findViewById(R.id.imageViewBag) as ImageView

        titleText.text = foods[position].name
        imageView.setImageResource(foods[position].imageId)
        priceText.text ="$".toString() +foods[position].price.toString()

        linLayout.setOnClickListener {
            onClickDetail(foods[position])
        }

        titleText.setOnClickListener {
            onClickDetail(foods[position])
        }

        imageView.setOnClickListener {
            onClickDetail(foods[position])
        }
        priceText.setOnClickListener {
            onClickDetail(foods[position])
        }

        imageBag.setOnClickListener {
            if(foods[position].isBagged) {
                foods[position].isBagged = false
                imageBag.setImageResource(R.drawable.ic_baseline_remove_shopping_cart_24)


//                var coroutineClass = CoroutineClass(foods[position],context).onCreate()

                CoroutineScope(Dispatchers.IO).launch {
                    var checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
                    if (checkoutGetAll!=null){

                    }
                }

//                (context as ItemActivity).setSPHasBag()

//               suspend fun temp() = coroutineScope {
//                    launch {
////                        (context as ItemActivity).runCoroutineScope()
//                    }
//                }


            }else{
                foods[position].isBagged = true
                imageBag.setImageResource(R.drawable.ic_baseline_shopping_cart_24)

                (context as ItemActivity).runCoroutineScope()
            }

        }


        return rowView
    }

    fun onClickDetail(food: FoodData) {
        var intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", food.id)
        intent.putExtra("name", food.name)
        intent.putExtra("imageid", food.imageId)
        intent.putExtra("price", food.price.toString())
        intent.putExtra("description", food.description)
        context.startActivity(intent)
    }

    fun abc(){

    }

}