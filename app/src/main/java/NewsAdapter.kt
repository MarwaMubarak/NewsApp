package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.news.Article
import com.squareup.picasso.Picasso

class NewsAdapter(var news:List<Article?>?):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title:TextView?  =null
        var image:ImageView? = null
        init {
            title=view.findViewById(R.id.title)
            image=view.findViewById(R.id.image)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var article=news?.get(position)
        holder.title?.text=article?.title
        Picasso.get().load(article?.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return news?.size?:0
    }
}