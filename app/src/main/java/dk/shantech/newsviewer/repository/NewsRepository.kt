package dk.shantech.newsviewer.repository

import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.Result
import dk.shantech.newsviewer.data.remote.NewsRemoteDataSource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) {

    suspend fun fetchNewsArticles(): Flow<Result<ArticleList>?> {
        return flow {
            emit(Result.loading())
            val result = newsRemoteDataSource.fetchNews()
           emit(result)
        }
    }

    suspend fun searchNewsArticles(query: String): Flow<Result<ArticleList>?> {
        return flow {
            emit(Result.loading())
            val result = newsRemoteDataSource.searchNews(query = query)
            emit(result)
        }
    }

}