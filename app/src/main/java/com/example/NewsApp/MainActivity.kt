package com.example.NewsApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.NewsApp.adapter.MainCustomAdapter
import com.example.NewsApp.services.NewsService

class MainActivity : AppCompatActivity() {

    lateinit var mainListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView = findViewById(R.id.mainListView)

        val newsService = NewsService()
        val run = Runnable {
            val newsResult = newsService.result()
            val customAdapter = MainCustomAdapter(this, newsResult)
            runOnUiThread {
                mainListView.adapter = customAdapter

                mainListView.setOnItemClickListener { adapterView, view, i, l ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("itemUrl", newsResult[i].href)
                    startActivity(intent)
                }
            }
        }
        Thread(run).start()

    }
}