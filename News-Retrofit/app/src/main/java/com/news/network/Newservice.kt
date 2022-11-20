package com.news.network

import com.news.models_retro.topnewsresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface newservice {
    @GET("top-headlines")
    fun gettoparticles(
        @Query("country")country : String,
        @Query("apikey") apikey:String
    ): Call<topnewsresponse>

}
//the above thing just says give me top headlines of the entered country with the following api key and return topnewsreponse as a call
//basically it will give us the data present in topnewsreponse