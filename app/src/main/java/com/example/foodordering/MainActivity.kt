package com.example.foodordering

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
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

        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)

/////////////////////////////////
        val categories = ArrayList<CategoryData>()
        val foodData = ArrayList<FoodData>()
        categories.add(CategoryData(1,"Chicken", R.drawable.chicken, foodData))
        foodData.add(FoodData(1,"Roast Chicken", R.drawable.roastchicken,5.5," World Famous Fries® are made with premium potatoes such as the Russet Burbank and the Shepody."))
        foodData.add(FoodData(2,"Red Chicken Curry", R.drawable.redchickencurry,6.6, "Red curry paste is a blend of lemongrass, galangal (Thai ginger), fresh red chilis, and fragrant spices" ))
        foodData.add(FoodData(3,"Butter Chicken", R.drawable.butterchicken,5.5,"Prepared in a buttery gravy with the addition of cream gives the curry sauce a silky smooth rich texture. Most restaurants are known to add in copious amounts of butter, which as a result can leave you feeling bloated or ill from the slick of grease."))
        foodData.add(FoodData(4,"Masala Roast Chicken", R.drawable.masalaroastchicken,6.6, "A whole roast chicken might sound difficult to make, but if you follow the instructions, this dish comes together fairly easily and with ingredients you already have at home. The end result is a perfectly cooked roast chicken that’s tender, juicy, and spicy!" ))
        foodData.add(FoodData(5,"Fried Chicken", R.drawable.friedchicken,5.5," Most batters include flour, salt, pepper, and some type of liquid (usually milk or water). You can also add spices like onion powder or garlic powder to give your chicken a boost of flavor"))
        foodData.add(FoodData(6,"Chicken fries", R.drawable.chicken,6.6, "It starts with seasoned boneless pork dipped in a tangy BBQ sauce, topped with slivered onions and dill pickles, all served on a toasted homestyle bun." ))

        val foodData1 = ArrayList<FoodData>()
        categories.add(CategoryData(2,"Beverages", R.drawable.beverages,foodData1))
        foodData1.add(FoodData(7,"Coca-Cola", R.drawable.cocacola,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData1.add(FoodData(8,"Hot Chocolate", R.drawable.hotchocolate,2.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData1.add(FoodData(9,"Milk Jug", R.drawable.milkjug,3.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData1.add(FoodData(10,"Sprite Small", R.drawable.spritesmall,1.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData1.add(FoodData(11,"Sweettea", R.drawable.sweettea,8.4," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        val foodData2 = ArrayList<FoodData>()
        categories.add(CategoryData(3,"Breakfast", R.drawable.breakfast,foodData2))
        foodData2.add(FoodData(12,"Big Breakfast", R.drawable.bigbreakfast,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData2.add(FoodData(13,"Fruit Maple Oatmeal", R.drawable.fruitmapleoatmeal,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData2.add(FoodData(14,"Hot Cakes", R.drawable.hotcakes,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData2.add(FoodData(15,"Sausage Burrito", R.drawable.sausageburrito,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData2.add(FoodData(16,"Sausage With Egg", R.drawable.sausagewithegg,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        val foodData3 = ArrayList<FoodData>()
        categories.add(CategoryData(4,"Bakery", R.drawable.bakery,foodData3))
        foodData3.add(FoodData(17,"Apple Fritter", R.drawable.applefritter,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData3.add(FoodData(18,"Blue Berry Muffin", R.drawable.blueberrymuffin,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData3.add(FoodData(19,"Cinnamon Roll", R.drawable.cinnamonroll,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))
        foodData3.add(FoodData(20,"Danish Cheese", R.drawable.danishcheese,5.5," Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."))

        categories.add(CategoryData(5,"Chicken and Fish Sandwiches", R.drawable.chickenfishsandwiches))
        categories.add(CategoryData(6,"Desserts", R.drawable.desserts))
        categories.add(CategoryData(7,"Fries and sides", R.drawable.friessides))
///////////////////////////////////
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
        var checkoutGetAll: List<Checkout>? = null
        CoroutineScope(Dispatchers.IO).launch {
            checkoutGetAll = CheckoutDatabase(context).getCheckoutDao().getAllCheckout()
        }

        for (i in 1..10) {
            Thread.sleep(100)
            if (checkoutGetAll != null) {
                if (checkoutGetAll != null && checkoutGetAll!!.size > 0) {
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