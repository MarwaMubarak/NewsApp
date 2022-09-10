package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.news.Article

class FavNewsActivity : AppCompatActivity() {
    var database: DataBasic? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_news)

        val rec = findViewById<RecyclerView>(R.id.rec2)

        rec.layoutManager = LinearLayoutManager(this)
        var list : List<Article>?=null
        val favNews = database?.getArticleDao()?.getArticles()
        if (favNews != null) {
            for (x in favNews){
                val article=NewsModel(title = x?.title, image = x?.image, url = x?.url, description = x?.description)
                
            }

        }
        val adapter = FavNewsAdapter(list)

        rec.adapter = adapter
    }

}