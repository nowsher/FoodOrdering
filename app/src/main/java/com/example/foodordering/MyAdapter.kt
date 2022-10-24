package com.example.foodordering

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list.view.*


class MyAdapter(var blist: ArrayList<Category>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.textNameCategory.text = blist[position].name
        holder.itemView.imageViewCategory.setImageResource(blist[position].image)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ItemActivity::class.java)
            intent.putExtra("name", blist[position].name)
            intent.putExtra("image", blist[position].image)
            holder.itemView.context.startActivity(intent);
        }

    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

