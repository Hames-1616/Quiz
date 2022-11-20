package com.news.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {
    private val BASE_URL = "https://newsapi.org/v2/"

    private val moshi =Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()




    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
//initializing
    val retrofitservice : newservice by lazy {
        retrofit.create(newservice::class.java)
    }
}