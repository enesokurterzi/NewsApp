package com.example.NewsApp.services

import com.example.NewsApp.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsService {

    fun result() :List<News> {
        val list = mutableListOf<News>()
        val url = "https://www.haberler.com/"
        val doc: Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = doc.getElementsByAttribute("data-headlinenumber")

        for (item in elements) {
            val img = item.getElementsByTag("img")

            val href = item.attr("abs:href")
            val src = img.attr("data-src")
            val title = img.attr("alt")

            if (title != "" && src != "" && href != "") {
                val news = News(title, src, href)
                list.add(news)
            }
        }
        return list
    }
}