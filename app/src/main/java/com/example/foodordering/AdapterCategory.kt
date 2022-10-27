package com.example.foodordering

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.CategoryData
import com.example.foodordering.R
import kotlinx.android.synthetic.main.order_list.view.*

class AdapterCategory(var blist: ArrayList<CategoryData>) : RecyclerView.Adapter<AdapterCategory.CategoryViewHolder>() {

    private var mMainActivity: MainActivity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AdapterCategory.CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterCategory.CategoryViewHolder, position: Int) {
        holder.itemView.textNameOrderName.text = blist[position].name
        holder.itemView.imageViewOrder.setImageResource(blist[position].imageId)

        holder.itemView.setOnClickListener {
            if (blist[position].foodData == null) {
                Toast.makeText(holder.itemView.context, "No food available", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(holder.itemView.context, ItemActivity::class.java)
            intent.putExtra("id", blist[position].id)
            intent.putExtra("name", blist[position].name)
            intent.putExtra("foods", blist[position].foodData as java.io.Serializable)

            mMainActivity = holder.itemView.context as MainActivity
            mMainActivity?.launchListActivity(intent)  // to track if closed.
        }

    }

    override fun getItemCount(): Int {
        return blist.size
    }

//    fun setClickListener(mainAct: MainActivity) {
//        this.mMainActivity = mainAct
//    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

