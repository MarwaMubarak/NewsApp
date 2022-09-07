package com.example.newsapp.news

import com.google.gson.annotations.SerializedName


data class Everything (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Article> = arrayListOf()

)