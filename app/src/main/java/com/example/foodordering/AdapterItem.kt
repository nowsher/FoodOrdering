package com.example.foodordering

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdapterItem(private val context: Activity, val foods: ArrayList<FoodData>) :
    ArrayAdapter<FoodData>(context, R.layout.item_list, foods) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        val priceText = rowView.findViewById(R.id.price) as TextView
        val linLayout = rowView.findViewById(R.id.linearLayout1) as LinearLayout
//        val imageBag = rowView.findViewById(R.id.imageViewBag) as ImageView
        val btnCart = rowView.findViewById(R.id.buttonCart) as Button

        titleText.text = foods[position].name
        imageView.setImageResource(foods[position].imageId)
        priceText.text = "$".toString() + foods[position].price.toString()
        //Set icon based on Ordered.
        if (foods[position].isBagged) {
//            imageBag.setImageResource(R.drawable.ic_baseline_remove_shopping_cart_24)
            btnCart.text="Remove"
            //btnCart.icon = "ic_baseline_shopping_cart_24"
        } else {
//            imageBag.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            btnCart.text="Add"
        }


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

        btnCart.setOnClickListener{
            if (foods[position].isBagged) {
                //Remove
                foods[position].isBagged = false
                btnCart.text="Add"
//                imageBag.setImageResource(R.drawable.ic_baseline_remove_shopping_cart_24)
//                imageBag.refreshDrawableState()
                //update memory list
                var tmpOrderData = Utility.getOrderObject().find {
                    it.foodData.id == foods[position].id
                }
                tmpOrderData?.foodData?.isBagged = false
                var v = Utility.getOrderObject()
                Utility.getOrderObject().remove(tmpOrderData)
                var q = Utility.getOrderObject()

                CoroutineScope(Dispatchers.IO).launch {
                    if (foods[position].id > 0) {
                        var x = CheckoutDatabase(context).getCheckoutDao()
                            .deleteCheckoutByFoodId(foods[position].id)
                    }
                }
            } else {
                //Add
                foods[position].isBagged = true
                btnCart.text="Remove"
//                imageBag.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
//                imageBag.refreshDrawableState()
                //update memory list
                var tmpOrderData = Utility.getOrderObject().find {
                    it.foodData.id == foods[position].id
                }
                tmpOrderData?.foodData?.isBagged = true
                var v = Utility.getOrderObject()
                Utility.getOrderObject().add(OrderData(-1, 1, foods[position]))
//                var q = Utility.getOrderObject()
                CoroutineScope(Dispatchers.IO).launch {
                    var x = CheckoutDatabase(context).getCheckoutDao()
                        .addCheckout(
                            Checkout(
                                1,
                                foods[position].name,
                                foods[position].id,
                                foods[position].imageId,
                                foods[position].price,
                                "",
                                Utility.getToken()
                            )
                        )
                }

            }
            (context as ItemActivity).updateOrderView(context)
        }


        return rowView
    }

    //Show Detail page
    fun onClickDetail(food: FoodData) {
        var intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", food.id)
        intent.putExtra("name", food.name)
        intent.putExtra("imageid", food.imageId)
        intent.putExtra("price", food.price.toString())
        intent.putExtra("description", food.description)
        context.startActivity(intent)
    }

}