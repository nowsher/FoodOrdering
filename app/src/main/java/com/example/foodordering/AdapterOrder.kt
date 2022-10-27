package com.example.foodordering

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.view.*
import kotlinx.android.synthetic.main.order_list.view.*
import java.text.DecimalFormat

class AdapterOrder(var blist: ArrayList<OrderData>) :
    RecyclerView.Adapter<AdapterOrder.OrderViewHolder>() {

    private var mOrderFragment: OrderFragment? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterOrder.OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_list, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterOrder.OrderViewHolder, position: Int) {

        holder.itemView.textNameOrderName.text = blist[position].foodData.name
        holder.itemView.imageViewOrder.setImageResource(blist[position].foodData.imageId)

        updatePrices(holder, position)

        holder.itemView.textViewPlus.setOnClickListener {
            blist[position].quantity++
            updatePrices(holder, position)
        }

        holder.itemView.textViewMinus.setOnClickListener {
            if (blist[position].quantity > 0) {
                blist[position].quantity--
                updatePrices(holder, position)
            }
        }

    }

    private fun updatePrices(holder: OrderViewHolder, position: Int) {
        holder.itemView.textViewQuantity.text = blist[position].quantity.toString()
        var totalPrice = blist[position].foodData.price * blist[position].quantity
        var df = DecimalFormat("#.##")
        var tmpPrice = df.format(totalPrice)
        holder.itemView.textViewPrice.text = "$".toString() + tmpPrice.toString()
        updateSubtotal()
    }

    override fun getItemCount(): Int {
        return blist.size
    }

    fun updateSubtotal() {
        var sum: Double = 0.0
        var orderList = Utility.getOrderObject()
        orderList.forEach {
            sum += it.quantity * it.foodData.price
        }
        var df = DecimalFormat("#.##")
        var tmpSub = df.format(sum)
        mOrderFragment?.textViewSubtotal?.text = "$".toString() + tmpSub.toString()
    }

    fun setParentContext(orderFragment: OrderFragment) {
        mOrderFragment = orderFragment
    }

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

