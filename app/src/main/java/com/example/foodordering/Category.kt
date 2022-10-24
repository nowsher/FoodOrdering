package com.example.foodordering


data class Category(var id:Int,var name: String,var imageId: Int, var foods:List<Food>? = null) :java.io.Serializable{

}