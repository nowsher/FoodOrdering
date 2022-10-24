package com.example.foodordering

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list.view.*


class AdapterCategory(var blist: ArrayList<Category>) : RecyclerView.Adapter<AdapterCategory.MyViewHolder>() {

    private var mMainActivity: MainActivity? = null

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int)
    : AdapterCategory.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterCategory.MyViewHolder, position: Int) {
        holder.itemView.textNameCategory.text = blist[position].name
        holder.itemView.imageViewCategory.setImageResource(blist[position].imageId)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, ItemActivity::class.java)
            intent.putExtra("id", blist[position].id)
            intent.putExtra("name", blist[position].name)
            intent.putExtra("foods", blist[position].foods as java.io.Serializable)

            //var order = Order(1,Food(1,"chicken",-1,5.5f,""),5)
            //Utility.getOrderObject().add(order)
//            var orders = Utility.getOrderObject()

            mMainActivity = holder.itemView.context as MainActivity
            mMainActivity?.launchListActivity(intent)  //holder.itemView.context.startActivity(intent);
        }

    }

    override fun getItemCount(): Int {
        return blist.size
    }

//    fun setClickListener(mainAct: MainActivity) {
//        this.mMainActivity = mainAct
//    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

