package com.example.foodordering

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var resultItems:ActivityResultLauncher<Intent?>
    lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///////////////////////////////
        sharedPref = getSharedPreferences("orderedItems", Context.MODE_PRIVATE)

/////////////////////////////////
        val categories = ArrayList<CategoryData>()
        val foodData = ArrayList<FoodData>()
        categories.add(CategoryData(1,"Chicken", R.drawable.chicken, foodData))
        foodData.add(FoodData(1,"Chicken fries", R.drawable.chicken,5.5," World Famous Fries® are made with premium potatoes such as the Russet Burbank and the Shepody."))
        foodData.add(FoodData(2,"Chicken fries1", R.drawable.chicken,6.6, "It starts with seasoned boneless pork dipped in a tangy BBQ sauce, topped with slivered onions and dill pickles, all served on a toasted homestyle bun." ))

        categories.add(CategoryData(2,"Beverages", R.drawable.beverages,foodData))
        categories.add(CategoryData(3,"Breakfast", R.drawable.breakfast,foodData))
        categories.add(CategoryData(4,"Bakery", R.drawable.bakery))
        categories.add(CategoryData(5,"Chicken and Fish Sandwiches", R.drawable.chickenfishsandwiches))
        categories.add(CategoryData(6,"Desserts", R.drawable.desserts))
        categories.add(CategoryData(7,"Fries and sides", R.drawable.friessides))
        categories.add(CategoryData(8,"Category7", R.drawable.ic_launcher_foreground))
        categories.add(CategoryData(9,"Category8", R.drawable.ic_launcher_foreground))
        categories.add(CategoryData(10,"Category9", R.drawable.ic_launcher_foreground))
        categories.add(CategoryData(11,"Category10", R.drawable.ic_launcher_foreground))
///////////////////////////////////

        recyclerView1.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterCategory(categories)
//        adapter.setClickListener(this)
        recyclerView1.adapter = adapter

        // Set Order bottom Fragment
        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutMainOrderBottom, OrderBottomFragment())
        fragTrans.commit()

//        setOrderBottomVisibility()
        updateOrderView(this)
//        Utility.updateOrderStatus(frameLayoutMainOrderBottom,this)

        resultItems = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            setOrderBottomVisibility()
            updateOrderView(this)
        }


    }

//    private fun setOrderBottomVisibility() {
//        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//            frameLayoutMainOrderBottom.visibility = LinearLayout.VISIBLE
//        } else {
//            frameLayoutMainOrderBottom.visibility = LinearLayout.GONE
//        }
//    }

    fun updateOrderView(context: Context) {
        lateinit var checkoutGetAll: List<Checkout>
        CoroutineScope(Dispatchers.IO).launch {
            checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
        }

        for (i in 1..10) {
            Thread.sleep(100)
            if (checkoutGetAll != null) {
                if (checkoutGetAll != null && checkoutGetAll.size > 0) {
                    frameLayoutMainOrderBottom.visibility = LinearLayout.VISIBLE
                } else {
                    frameLayoutMainOrderBottom.visibility = LinearLayout.GONE
                }
                break
            }
        }
    }

    fun  launchListActivity(intent:Intent){
        resultItems.launch(intent)
    }




}