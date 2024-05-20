package network

import data.model.NewsResponse

interface NewsApi {
    suspend fun getCategoryNews(category: String): NewsResponse
}
