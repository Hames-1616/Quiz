package com.news.models_retro
import com.news.models_retro.article_category.*

enum class article_category(val categoryName : String) {
    BUSSINESS("business"),
    ENTERTAINMENT("entertainment"),
    GENERAL("general"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology")
}


fun getallcategory():List<article_category>
{
    return listOf(article_category.BUSSINESS,
        article_category.ENTERTAINMENT,
        article_category.GENERAL,
        article_category.HEALTH,
        article_category.SCIENCE,
        article_category.SPORTS,
        article_category.TECHNOLOGY


        )
}

fun getart(category: String) : article_category?
{
    val map = values().associateBy(article_category::categoryName)
    return map[category]

}