package com.example.foodordering

import android.app.Activity
import android.graphics.Bitmap
import androidx.activity.result.ActivityResultRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutineClass(food: FoodData, context: Activity) {
    var foodItem = food
    var ContextItem = context
    fun onCreate() {
        GlobalScope.launch {
            coroutineFunction(foodItem, ContextItem)
        }
    }

    suspend fun coroutineFunction(food: FoodData, context: Activity) {
        // Use a different CoroutineScope, etc
        CoroutineScope(Dispatchers.IO).launch {
            var checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
            if (checkoutGetAll!=null){

            }
        }
    }
}