package com.example.newsapp.news

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")
    fun everything(@Query("q") query: String,@Query("apiKey")apiKey:String): Call<Everything>
}

var retrofit =Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
var service :NewsApi = retrofit.create(NewsApi::class.java)
