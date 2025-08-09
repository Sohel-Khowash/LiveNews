package com.example.livenews.repository

import com.example.livenews.api.RetrofitInstance
import com.example.livenews.db.ArticleDatabase
import com.example.livenews.models.Article

class NewsRepository( private val db: ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) {
        db.getArticleDao().upsert(article)
    }

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(articleId: Int?) {
        db.getArticleDao().deleteArticle(articleId)
    }
}