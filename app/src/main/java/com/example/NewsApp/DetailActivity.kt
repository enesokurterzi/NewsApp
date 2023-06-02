package com.example.NewsApp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    lateinit var detailWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailWebView = findViewById(R.id.detailWebView)

        val itemUrl = intent.getStringExtra("itemUrl")
        detailWebView.settings.javaScriptEnabled = true
        detailWebView.webViewClient = WebViewClient()
        if (itemUrl != null) {
            detailWebView.loadUrl(itemUrl)
        }
    }
}