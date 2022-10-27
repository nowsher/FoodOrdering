package com.example.foodordering

//import com.example.foodordering.db.CheckoutDatabase
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_order.*
import kotlin.random.Random
import kotlin.random.nextInt

class OrderFragment : BaseFragment() {
    lateinit var orderList: ArrayList<OrderData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_order, container, false)


        orderList = ArrayList<OrderData>()
        //fill only bagged items.
//        Utility.fillOrderData(context)
        Utility.getOrderObject().forEach{
            if (it.foodData.isBagged){
                orderList.add(it)
            }
        }

        // load RecyclerView in Order Fragment
        var recView = view.findViewById(R.id.recyclerView2) as RecyclerView
        recView.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterOrder(orderList)   //
        adapter.setParentContext(this)
        recView.adapter = adapter

        var btnPayment = view.findViewById(R.id.buttonPayment) as Button
        btnPayment.setOnClickListener {
            val min = 10
            val max = 50
            val random: Int = Random.nextInt(max - min + 1) + min
            val min2 = 51
            val max2 = 99
            val random2: Int = Random.nextInt(max - min + 1) + min

            val intent = Intent(context, TokenActivity::class.java)
            intent.putExtra("token1", random.toString())
            intent.putExtra("token2", random2.toString())
            startActivity(intent)
        }

        return view
    }

}