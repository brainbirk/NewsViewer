package dk.shantech.newsviewer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dk.shantech.newsviewer.repository.NewsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(newsRepository: NewsRepository) : ViewModel() {

    init {
        Log.d("Here", "MainViewModel")
        viewModelScope.launch {
            newsRepository.searchNewsArticles("bitcoin").collect {
                Log.d("Here", "MainViewModel: $it")
            }
        }

    }

}