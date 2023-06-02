package com.example.NewsApp.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.NewsApp.R
import com.example.NewsApp.models.News

class MainCustomAdapter(private val context: Activity, private val list: List<News>) : ArrayAdapter<News>(context, R.layout.custom_list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.custom_list_item, null, true)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_text = rootView.findViewById<TextView>(R.id.r_text)

        val news = list[position]

        Glide.with(rootView).load(news.img).into(r_image)

        r_text.text = news.title

        return rootView
    }
}