package dk.shantech.newsviewer.data.model

data class ArticleSourceList(
    val sources: List<Source> = emptyList(),
    val status: String
)

data class Source(
    val category: String,
    val country: String,
    val description: String,
    val id: String,
    val language: String,
    val name: String,
    val url: String
)