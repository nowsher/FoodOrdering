package com.example.foodordering

data class OrderData(var id:Int, var quantity:Int, var foodData:FoodData)
    :java.io.Serializable {

}