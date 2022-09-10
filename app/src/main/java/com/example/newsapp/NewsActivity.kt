package com.example.newsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.news.Everything
import com.example.newsapp.news.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val kapiKey = "fcba2deef5df47bbbed4eab04a1900a6"

//fcba2deef5df47bbbed4eab04a1900a6
class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val logout: Button = findViewById(R.id.logoutBtn)
        val fav: Button = findViewById(R.id.favBtn)

        supportFragmentManager.beginTransaction().replace(R.id.f1, NewsFragment()).commit()
        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        fav.setOnClickListener {
            val intent =Intent(this,FavNewsActivity::class.java)
            startActivity(intent)

        }

    }


}