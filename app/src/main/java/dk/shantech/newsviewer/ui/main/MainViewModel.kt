package dk.shantech.newsviewer.ui.main

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.shantech.newsviewer.data.model.Article
import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.Result
import dk.shantech.newsviewer.data.model.Result.Status.*
import dk.shantech.newsviewer.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val newsRepository: NewsRepository) : ViewModel() {

    var adaptor = MainRecyclerViewAdaptor(onArticleClick = {article -> Log.d("Here", "MainViewModel: Article clicked: ${article}") })

    var data = ObservableField<List<Article>>()

    init {
        viewModelScope.launch() {
            newsRepository.fetchTopHeadlines().collect { result ->
                when(result.status) {
                    SUCCESS -> {
                        Log.d("Here", "MainViewModel: Success:  ${result.data}")
                        result.data?.articles?.let { data.set(it) }
                    }
                    ERROR -> Log.d("Here", "MainViewModel: Error: ${result.error}")
                    LOADING -> Log.d("Here", "MainViewModel: Loading")
                }
            }
        }
    }
}