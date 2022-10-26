package com.example.foodordering

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordering.db.Checkout
import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.fragment_order.*
//import com.example.foodordering.db.CheckoutDatabase
import kotlinx.coroutines.launch

class OrderFragment : BaseFragment() {
    lateinit var orderList: ArrayList<OrderData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_order, container, false)

        orderList = Utility.getOrderObject()
//        orderList.add(OrderData(1, 3, FoodData(1, "Chicken", R.drawable.chicken, 5.5)))
//        orderList.add(
//            OrderData(
//                2,
//                1,
//                FoodData(2, "Chicken negates", R.drawable.chickenfishsandwiches, 7.5)
//            )
//        )

        var recView = view.findViewById(R.id.recyclerView2) as RecyclerView
        recView.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterOrder(orderList)
        adapter.setParentContext(this)
        recView.adapter = adapter


        var btnPayment = view.findViewById(R.id.buttonPayment) as Button
        btnPayment.setOnClickListener {

            val intent = Intent(context, TokenActivity::class.java)
            startActivity(intent)


//            launch {
//                context?.let {
////                    val checkoutGetAll = CheckoutDatabase(it).getCheckoutDao().getAllCheckout()
////                    CheckoutDatabase(it).getCheckoutDao().clearTable()
//
////                    CheckoutDatabase(it).getCheckoutDao()
////                        .addCheckout(Checkout("Nowsher", 3, 1,5.5))
//
//                    var checkoutGetAll = CheckoutDatabase(it).getCheckoutDao().getAllCheckout()
//                    if (checkoutGetAll != null) {
//                        var id = checkoutGetAll.get(0).id
//                        var v = orderList.find {
//                            it.id == id
//                        }
//                        if (v != null) {//update
//                            var c = Checkout(
//                                v.quantity,
//                                v.foodData.name,
//                                v.foodData.id,
//                                v.foodData.imageId,
//                                v.foodData.price,
//                                v.foodData.description
//                            )
//                            CheckoutDatabase(it).getCheckoutDao().updateCheckout(c)
//                        }
//                        else{//insert
//
//                        }
//                    }
//                }
//            }



        }



        return view
    }

//    fun updateSubtotal() {
//        var sum: Double = 0.0
//        orderList.forEach {
//            sum += it.quantity * it.foodData.price
//        }
//        textViewSubtotal.text = "$".toString() + sum.toString()
//    }

}