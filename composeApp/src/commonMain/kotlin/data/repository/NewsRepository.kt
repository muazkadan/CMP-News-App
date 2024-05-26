package data.repository

import network.NewsApi

class NewsRepository(
    private val newsApi: NewsApi,
) {
    suspend fun getCategoryNews(category: String) = newsApi.getCategoryNews(category)
}
