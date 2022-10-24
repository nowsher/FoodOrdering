package com.example.foodordering

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
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

//        Utility.setOrderBotomVisibility()

        val categories = ArrayList<Category>()
        val foods = ArrayList<Food>()
        categories.add(Category(1,"Chicken", R.drawable.chicken, foods))
        foods.add(Food(1,"Chicken fries", R.drawable.chicken,5.5f))
        foods.add(Food(2,"Chicken fries", R.drawable.chicken,6.6f))

        categories.add(Category(2,"Beverages", R.drawable.beverages))
        categories.add(Category(3,"Breakfast", R.drawable.breakfast))
        categories.add(Category(4,"Bakery", R.drawable.bakery))
        categories.add(Category(5,"Chicken and Fish Sandwiches", R.drawable.chickenfishsandwiches))
        categories.add(Category(6,"Desserts", R.drawable.desserts))
        categories.add(Category(7,"Fries and sides", R.drawable.friessides))
        categories.add(Category(8,"Category7", R.drawable.ic_launcher_foreground))
        categories.add(Category(9,"Category8", R.drawable.ic_launcher_foreground))
        categories.add(Category(10,"Category9", R.drawable.ic_launcher_foreground))
        categories.add(Category(11,"Category10", R.drawable.ic_launcher_foreground))



        recyclerView1.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterCategory(categories)
//        adapter.setClickListener(this)
        recyclerView1.adapter = adapter

        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutMainOrderBottom, OrderBottomFragment())
        fragTrans.commit()


        setOrderBottomVisibility()

//        var spEdit = sp.edit()
//        spEdit.putBoolean("hasItem",false)
//        spEdit.apply()

//        sp.registerOnSharedPreferenceChangeListener { sharedPreferences, sKey ->
//            if(sKey.equals("hasItem")){
//                frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//            }
//        }

////        var hasItem = sp.getBoolean("hasItem",false)
//        if (!hasItem) {
//            linearLayoutOrderBottom.visibility = LinearLayout.GONE
//        }

//        linearLayoutOrderBottom.setOnClickListener{
//            Toast.makeText(this,"Hi",Toast.LENGTH_LONG ).show()
//        }

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