package dk.shantech.newsviewer.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleList(
    val articles: List<Article> = emptyList(),
    val status: String,
    val totalResults: Int = 0
)