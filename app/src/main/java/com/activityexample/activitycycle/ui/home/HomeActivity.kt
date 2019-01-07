package com.activityexample.activitycycle.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import com.activityexample.activitycycle.R
import com.activityexample.activitycycle.repository.remove.OMDbApiManager
import com.activityexample.activitycycle.ui.model.Movie
import com.activityexample.activitycycle.ui.model.Result
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun populateRecyclerView(list: List<Result>) {
        rvSearchResult.adapter = HomeAdapter(list) {
        }
    }

    private fun init() {
        makeRequest("spider man")

        svMoviesFinder.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    // homePresenter.requestDataMovie(query)
                    makeRequest(query)
                } else {
                    Toast.makeText(this@HomeActivity, "error", Toast.LENGTH_SHORT).show()
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
        })
    }

    fun makeRequest(query: String?) {
        val call: Call<Movie> = OMDbApiManager
                .getRetrofit()
                .movieList("fa155f635119344d33fcb84fb807649b", query!!)

        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(" M- ON FAILURE", "FAILURE ${t.message}")
                Toast.makeText(this@HomeActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    val moviesList: Movie = response.body()!!
                    populateRecyclerView(moviesList.results)
                    Log.e(" M- manuela", "ON succes")
                } else {
                    Log.e(" M- manuela", "ON ERROR ${response.message()}")
                    Toast.makeText(this@HomeActivity, "${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
