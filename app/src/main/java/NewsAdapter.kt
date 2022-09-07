package com.example.newsapp
//import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.news.Article
import com.squareup.picasso.Picasso

class NewsAdapter(var news:List<Article?>?):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title:TextView?  =null
        var btn:Button?=null
        var image:ImageView? = null
        init {
            title=view.findViewById(R.id.title)
            image=view.findViewById(R.id.image)
            btn=view.findViewById(R.id.btn)
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
        holder.btn?.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(article?.url)
           it.context.startActivity(openURL)
        }

    }

    override fun getItemCount(): Int {
        return news?.size?:0
    }
}