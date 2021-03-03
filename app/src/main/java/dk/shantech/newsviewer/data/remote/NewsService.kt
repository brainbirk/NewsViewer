package dk.shantech.newsviewer.data.remote

import dk.shantech.newsviewer.BuildConfig
import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.ArticleSourceList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything")
    suspend fun getSearchNews(@Query("q") query: String) : Response<ArticleList>

    @GET("v2/everything")
    suspend fun getAllNews(@Header("Authorization") key: String = BuildConfig.API_KEY) : Response<ArticleList>

    @GET("v2/sources")
    suspend fun getSources(@Header("Authorization") key: String = BuildConfig.API_KEY) : Response<ArticleSourceList>

}