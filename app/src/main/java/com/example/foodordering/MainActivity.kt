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
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var resultItems:ActivityResultLauncher<Intent?>
    lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///////////////////////////////
        sharedPref = getSharedPreferences("orderedItems", Context.MODE_PRIVATE)

//        supportActionBar?.setIcon(R.mipmap.ic_launcher);

//        supportActionBar?.setTitle("My new title") // set the top title
//        val title = actionBar?.getTitle().toString() // get the title
//        actionBar?.hide() // or even hide the actionbar

//        supportActionBar?.setDisplayShowHomeEnabled(true);
//        supportActionBar?.setLogo(R.mipmap.ic_launcher);
//        supportActionBar?.setDisplayUseLogoEnabled(true);

//        val tv = TextView(applicationContext)
//        val lp: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
//            LayoutParams.MATCH_PARENT,  // Width of TextView
//            LayoutParams.WRAP_CONTENT
//        )
//        tv.layoutParams = lp
//        tv.setTextColor(Color.RED)
//        supportActionBar?.setCustomView(tv)

//        frameLayoutMainOrderBottom.visibility = FrameLayout.GONE

        val categories = ArrayList<CategoryData>()
        val foodData = ArrayList<FoodData>()
        categories.add(CategoryData(1,"Chicken", R.drawable.chicken, foodData))
        foodData.add(FoodData(1,"Chicken fries", R.drawable.chicken,5.5))
        foodData.add(FoodData(2,"Chicken fries", R.drawable.chicken,6.6))

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

        recyclerView1.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterCategory(categories)
//        adapter.setClickListener(this)
        recyclerView1.adapter = adapter

        // Set Order Fragment
        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutMainOrderBottom, OrderBottomFragment())
        fragTrans.commit()

        setOrderBottomVisibility()

        resultItems = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            setOrderBottomVisibility()
//                if (result.resultCode == Activity.RESULT_OK) {
//                    var x = result.data?.getStringExtra("xyz")
//                    var v: String = result.data?.data.toString()
//
//                    val temp = result.data?.getSerializableExtra("user")
//                    var userAccount = temp as UserAccount
//                    if (userAccount != null){
//                        userList.add(userAccount)
//                    }
//                }
        }


    }

    private fun setOrderBottomVisibility() {
        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
            frameLayoutMainOrderBottom.visibility = LinearLayout.VISIBLE
        } else {
            frameLayoutMainOrderBottom.visibility = LinearLayout.GONE
        }
    }

    fun  launchListActivity(intent:Intent){
        Toast.makeText(this,"Hello",Toast.LENGTH_LONG ).show()

        resultItems.launch(intent)
    }


}