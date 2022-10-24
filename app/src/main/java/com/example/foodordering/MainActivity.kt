package com.example.foodordering

import android.app.Activity
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
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var resultItems:ActivityResultLauncher<Intent?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///////////////////////////////
        
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



        val categories = ArrayList<Category>()
        categories.add(Category("Chicken", R.drawable.chicken))
        categories.add(Category("Beverages", R.drawable.beverages))
        categories.add(Category("Breakfast", R.drawable.breakfast))
        categories.add(Category("Bakery", R.drawable.bakery))
        categories.add(Category("Chicken and Fish Sandwiches", R.drawable.chickenfishsandwiches))
        categories.add(Category("Desserts", R.drawable.desserts))
        categories.add(Category("Fries and sides", R.drawable.friessides))
        categories.add(Category("Category7", R.drawable.ic_launcher_foreground))
        categories.add(Category("Category8", R.drawable.ic_launcher_foreground))
        categories.add(Category("Category9", R.drawable.ic_launcher_foreground))
        categories.add(Category("Category10", R.drawable.ic_launcher_foreground))

        // Set the Layout Manager
        recyclerView1.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(categories)
//        adapter.setClickListener(this)
        // Set adapter to your RecyclerView
        recyclerView1.adapter = adapter

        var fragManager = supportFragmentManager
        var fragTrans: FragmentTransaction = fragManager.beginTransaction()
        fragTrans.add(R.id.frameLayoutOrderBottom, OrderBottomFragment())
        fragTrans.commit()


        //setOrderBottomVisibility()

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

//                setOrderBottomVisibility()

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

//    private fun setOrderBottomVisibility() {
//        var sp: SharedPreferences = getSharedPreferences("orderedItems", MODE_PRIVATE)
//        if (sp.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//            frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//        } else {
//            frameLayoutOrderBottom.visibility = LinearLayout.INVISIBLE
//        }
//    }

    fun  launchListActivity(intent:Intent){
        Toast.makeText(this,"Hello",Toast.LENGTH_LONG ).show()
        resultItems.launch(intent)
    }

}