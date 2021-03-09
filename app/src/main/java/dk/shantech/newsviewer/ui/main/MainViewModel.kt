package dk.shantech.newsviewer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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

    lateinit var test: Result<ArticleList>

    init {
        Log.d("Here", "MainViewModel")
        viewModelScope.launch() {
            newsRepository.fetchTopHeadlines().collect { result ->
                Log.d("Here", "MainViewModel: $result")
            }
//            getNews()
            Log.d("Here","MainViewModel: I'm working in thread ${Thread.currentThread().name}")
        }

    }

    private suspend fun getNews() = withContext(Dispatchers.IO) {

        try {


        newsRepository.fetchTopHeadlines().collect { result ->
            Log.d("Here", "MainViewModel: $result")
            when(result?.status) {
                SUCCESS -> TODO()
                ERROR -> TODO()
                LOADING -> TODO()
            }
        }
        } catch (e: Throwable) {
                 println("Exception from the flow: $e")
        }
    }

}