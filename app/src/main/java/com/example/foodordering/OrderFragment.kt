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
        Utility.getOrderObject().forEach {
            if (it.foodData.isBagged) {
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
            val intent = Intent(context, TokenActivity::class.java)
            intent.putExtra("token", Utility.getToken())
            startActivity(intent)
        }

        var btnMore = view.findViewById(R.id.buttonMore) as Button
        btnMore.setOnClickListener {
            var v = getActivity() as OrderActivity
            v.finish()
        }

        return view
    }

}