package com.example.foodordering

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class OrderBottomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_order_bottom, container, false)

        var lilearBottom: LinearLayout =
            view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
        lilearBottom.setOnClickListener {
            Toast.makeText(context, "Hi", Toast.LENGTH_LONG).show()
        }


//        var sharedPref = this.activity?.getSharedPreferences("orderedItems", Context.MODE_PRIVATE)
//        sharedPref?.registerOnSharedPreferenceChangeListener { sharedPreferences, sKey ->
//
//            var frameLayoutOrderBottom: LinearLayout =
//                view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
//            var frame = frameLayoutOrderBottom.parent as FrameLayout
//
//            if (sKey.equals("hasItem")) {
//                if (sharedPref.getBoolean(sKey, false)) {
//                    frameLayoutOrderBottom.visibility = LinearLayout.VISIBLE
//                    frame.visibility = LinearLayout.VISIBLE
//                } else {
//                    frameLayoutOrderBottom.visibility = LinearLayout.GONE
//                    frame.visibility = LinearLayout.GONE
//                }
//            }
//        }

        return view
    }


//    private fun setOrderBottomVisibility(view:View) {
//        val sp = this.activity?.getSharedPreferences("orderedItems", Context.MODE_PRIVATE)
//        var frameOrderBottom:LinearLayout = view.findViewById(R.id.linearLayoutOrderBottom) as LinearLayout
//        if (sp!!.contains("hasItem") && sp.getBoolean("hasItem", false)) {
//            frameOrderBottom.visibility = LinearLayout.VISIBLE
//        } else {
//            frameOrderBottom.visibility = LinearLayout.INVISIBLE
//        }
//    }


}