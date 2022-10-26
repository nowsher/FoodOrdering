package com.example.foodordering


data class CategoryData(var id:Int, var name: String, var imageId: Int, var foodData:List<FoodData>? = null)
    :java.io.Serializable{

}