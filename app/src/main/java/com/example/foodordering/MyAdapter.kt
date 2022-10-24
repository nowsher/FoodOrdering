package com.example.foodordering

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list.view.*


class MyAdapter(var blist: ArrayList<Category>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//    private var mMainActivity: MainActivity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
//        var v = this
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.textNameCategory.text = blist[position].name
        holder.itemView.imageViewCategory.setImageResource(blist[position].image)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ItemActivity::class.java)
            intent.putExtra("name", blist[position].name)
            intent.putExtra("image", blist[position].image)

//            mMainActivity?.abc(intent) //launched by MainActivity
            var v:MainActivity= holder.itemView.context as MainActivity
            v.launchListActivity(intent)

//            holder.itemView.context.startActivity(intent);

        }

//        var resultContracts =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//                if (result.resultCode == Activity.RESULT_OK) {
////                    var v: String = result.data?.data.toString()
//
//                    val temp = result.data?.getSerializableExtra("user")
//                    var userAccount = temp as UserAccount
//                    if (userAccount != null){
//                        userList.add(userAccount)
//                    }
//                    Toast.makeText(this,"User created successfully", Toast.LENGTH_LONG)
//                } else {
//                    Toast.makeText(this,"User creation failed!", Toast.LENGTH_LONG)
//                }
//            }


    }

    override fun getItemCount(): Int {
        return blist.size
    }

//    // allows clicks events to be caught
//    fun setClickListener(mainAct: MainActivity) {
//        this.mMainActivity = mainAct
//    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

