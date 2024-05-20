package data.repository

import kotlinx.coroutines.CoroutineScope
import network.NewsApi

class NewsRepository(
    private val newsApi: NewsApi,
    private val scope: CoroutineScope
) {
    suspend fun getCategoryNews(category: String) = newsApi.getCategoryNews(category)
}