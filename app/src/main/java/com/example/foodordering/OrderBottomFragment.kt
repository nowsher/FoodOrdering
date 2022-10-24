package com.example.foodordering

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_order_bottom.*

class OrderBottomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_order_bottom, container, false)

        var lilearBottom:LinearLayout = view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
        lilearBottom.setOnClickListener{
            Toast.makeText(context,"Hi", Toast.LENGTH_LONG ).show()
        }
        setOrderBottomVisibility(view)

        return view
    }

    private fun setOrderBottomVisibility(view:View) {
        val sp = this.activity?.getSharedPreferences("orderedItems", Context.MODE_PRIVATE)
        var frameOrderBottom:LinearLayout = view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
        if (sp!!.contains("hasItem") && sp.getBoolean("hasItem", false)) {
            frameOrderBottom.visibility = LinearLayout.VISIBLE
        } else {
            frameOrderBottom.visibility = LinearLayout.INVISIBLE
        }
    }


}