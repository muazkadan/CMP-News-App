package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("category") val category: String,
    @SerialName("data") val data: List<News>,
    @SerialName("error") val error: String? = null,
    @SerialName("success") val success: Boolean
)

@Serializable
data class News(
    @SerialName(value = "author") val author: String,
    @SerialName(value = "content") val content: String,
    @SerialName(value = "date") val date: String,
    @SerialName(value = "imageUrl") val imageUrl: String,
    @SerialName(value = "readMoreUrl") val readMoreUrl: String?,
    @SerialName(value = "time") val time: String,
    @SerialName(value = "title") val title: String,
    @SerialName(value = "url") val url: String
)
