package com.example.foodordering

data class Order(var id:Int, var food:Food, var quantity:Int)
    :java.io.Serializable {

}