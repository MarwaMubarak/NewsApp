package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.news.Article
import com.example.newsapp.news.Everything
import com.example.newsapp.news.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
const val kapiKeyy="fcba2deef5df47bbbed4eab04a1900a6"
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var NewsAdapter:NewsAdapter
    private lateinit var rec:RecyclerView
    var list:ArrayList<Article>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putStringArrayList("list",list)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsAdapter= NewsAdapter(listOf())
        //getData()
        val layout =LinearLayoutManager(context)
        rec = view.findViewById(R.id.rec)
        rec.layoutManager=layout
        rec.adapter=NewsAdapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }
    fun getData() {
        service.everything("Egypt", kapiKeyy).enqueue(object : Callback<Everything> {
            override fun onResponse(call: Call<Everything>, response: Response<Everything>) {
                if (response.isSuccessful) {
                    NewsAdapter?.news = response.body()?.articles
                    list= response.body()?.articles!!
                    rec?.adapter=NewsAdapter
                }
            }

            override fun onFailure(call: Call<Everything>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}