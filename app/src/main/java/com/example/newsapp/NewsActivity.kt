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

const val kapiKey="fcba2deef5df47bbbed4eab04a1900a6"

//fcba2deef5df47bbbed4eab04a1900a6
class NewsActivity : AppCompatActivity() {
    private var newsAdapter :NewsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        ///////////////////////////////////////
        val logout: Button =findViewById(R.id.logoutBtn)
        logout.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        /////////////////////////////////////////////


        val rec:RecyclerView=findViewById(R.id.rec)
//        rec.setOnClickListener{
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse())
//            startActivity(browserIntent)
//        }

        rec.layoutManager=LinearLayoutManager(this)
        newsAdapter= NewsAdapter(listOf())
        getData()
        rec.adapter=newsAdapter


    }
    fun getData(){
        service.everything("programming", kapiKey).enqueue(object :Callback<Everything>{
            override fun onResponse(call: Call<Everything>, response: Response<Everything>) {
                if(response.isSuccessful){
                   // val  titles =response.body()?.articles?.map { it.title }
                    newsAdapter?.news=response.body()?.articles
                    println("-----------------------------------------------------------")
                    println("-----------------------------------------------------------")

                    println(response.body())
                    newsAdapter?.notifyDataSetChanged()
                    println("-----------------------------------------------------------")
                    println("-----------------------------------------------------------")


                }
            }

            override fun onFailure(call: Call<Everything>, t: Throwable) {
                Toast.makeText(this@NewsActivity,t.localizedMessage,Toast.LENGTH_SHORT).show()
            }

        })
    }


}