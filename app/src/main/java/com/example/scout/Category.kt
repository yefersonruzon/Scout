package com.example.scout

enum class Category (val value: String){
    ALL("All"),
    BEACH("Beach"),
    MOUNTAIN("Mountain"),
    ASIA("ASIA"),
    EUROPE("EUROPE")
}

fun getAllCategories(): List<Category>{
    return listOf(Category.ALL, Category.ASIA, Category.BEACH, Category.MOUNTAIN, Category.EUROPE)
}
fun getCategory(value: String): Category?{
    val map = Category.values().associateBy(Category::value)
    return  map[value]
}