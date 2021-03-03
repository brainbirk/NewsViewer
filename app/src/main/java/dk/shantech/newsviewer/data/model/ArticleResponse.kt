package dk.shantech.newsviewer.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: SourceResponse,
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
)

@Serializable
data class SourceResponse(
    val id: String = "",
    val name: String = ""
)