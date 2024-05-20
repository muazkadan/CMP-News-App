package network

import data.model.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsNetworkApi(private val httpClient: HttpClient, private val baseUrl: String): NewsApi {
    override suspend fun getCategoryNews(category: String): NewsResponse {
        val url = "$baseUrl/news?category=${category.lowercase()}"
        return try {
            httpClient.get(url).body()
        } catch (e: Exception) {
            e.printStackTrace()
            NewsResponse("", emptyList(), e.message, false)
        }
    }

}