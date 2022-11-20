package com.news.models_retro

data class topnewsresponse(
    val status : String? = null,
    val totalResults : Int? = null,
    val articles : List<topnewsarticle>?=null
)
