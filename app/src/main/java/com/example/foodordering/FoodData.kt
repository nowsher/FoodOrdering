package com.example.foodordering

data class FoodData(
    var id: Int,
    var name: String,
    var imageId: Int,
    var price: Double,
    var description: String = "",
    var isBagged: Boolean = false
) : java.io.Serializable {

}