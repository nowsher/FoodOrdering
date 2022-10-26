package com.example.foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.foodordering.db.Checkout
//import com.example.foodordering.db.CheckoutDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity(){
//    lateinit var orderList: ArrayList<OrderData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        ///////////////////////////////////////

//        orderList = Utility.getOrderObject()
//        orderList.add(OrderData(1, FoodData(1, "Chicken", R.drawable.chicken, 5.5f), 3))
//        orderList.add(
//            OrderData(
//                2,
//                FoodData(2, "Chicken negates", R.drawable.chickenfishsandwiches, 7.5f),
//                1
//            )
//        )
//
//        recyclerView2.layoutManager = LinearLayoutManager(this)
//        val adapter = AdapterOrder(orderList)
//        recyclerView2.adapter = adapter

        var fragTrans: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragTrans.add(R.id.frameLayout1, OrderFragment())
        fragTrans.commit()


//        buttonPayment.setOnClickListener {
//            Toast.makeText(this.applicationContext,"Hello",Toast.LENGTH_LONG)

//            suspend fun temp() = coroutineScope {
//                launch {
//                    applicationContext?.let {
//                            val checkout = CheckoutDatabase(it).getCheckoutDao().getAllCheckout()
////                            recycler_view_notes.adapter = NotesAdapter(notes)
//                    }
//                }
//            }

//            launch {
//                context?.let {
////                    val mNote = Note(noteTitle, noteBody)
////                    // note == null means Inserting a new Note
////                    if (note == null) {
////                        NoteDatabase(it).getNoteDao().addNote(mNote)
////                        it.toast("Note Saved")
////                    } else {
////                        // Update the note
////                        mNote.id = note!!.id
////                        NoteDatabase(it).getNoteDao().updateNote(mNote)
////                        it.toast("Note Updated")
////                    }
////                    // after adding a note need to return to Home_Fragment as per the navigation directions
////                    val action = AddNoteFragmentDirections.actionSaveNote()
////                    Navigation.findNavController(view).navigate(action)
////
//                }
//            }

//        }



    }


}