package com.example.foodordering

import android.app.ActionBar.LayoutParams
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
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
        // Set adapter to your RecyclerView
        recyclerView1.adapter = adapter



        linearLayoutOrderBottom.visibility = LinearLayout.GONE
        linearLayoutOrderBottom.setOnClickListener{
            Toast.makeText(this,"Hi",Toast.LENGTH_LONG ).show()
        }

    }

}