package dk.shantech.newsviewer.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import dk.shantech.newsviewer.data.model.Article

class MainItemViewModel(private val article: Article, private val onArticleClick: (article: Article) -> Unit) : ViewModel() {

    val date = article.publishedAt

    val title = article.title

    val imgUrl = article.urlToImage

    fun onClick() {
        onArticleClick.invoke(article)
    }

    init {
        Log.d("Here", "MainItemViewModel $article")
    }
}