package com.example.foodordering

data class Food(var id: Int, var name: String, var imageId: Int, var price: Float, var description:String="")
    :java.io.Serializable {

}