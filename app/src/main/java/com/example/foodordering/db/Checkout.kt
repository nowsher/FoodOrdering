package com.example.foodordering.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Checkout(
    val quantity: Int, val foodname: String, val foodid: Int,
    val foodimage: Int, val price: Double, val description: String
) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}