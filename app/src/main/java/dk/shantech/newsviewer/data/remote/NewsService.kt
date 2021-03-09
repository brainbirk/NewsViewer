package dk.shantech.newsviewer.data.remote

import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.ArticleSourceList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") query: String = "",
        @Query("qInTitle") qInTitle: String = "",
        @Query("sources") sources: String = "",
        @Query("domains") domains: String = "",
        @Query("excludeDomains") excludeDomains: String = "",
        @Query("from") from: String = "",
        @Query("to") to: String = "",
        @Query("language") language: String = "",
        @Query("sortBy") sortBy: String = "",
        @Query("pageSize") pageSize: Int = 100,
        @Query("page") page: Int = 1
    ) : Response<ArticleList>

    @GET("v2/sources")
    suspend fun getSources(
        @Query("category") category: String = "",
        @Query("language") language: String = "",
        @Query("country") country: String = ""
    ) : Response<ArticleSourceList>

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String = "",
        @Query("category") category: String = "",
        @Query("sources") sources: String = "",
        @Query("q") query: String = "",
        @Query("pageSize") pageSize: Int = 20,
        @Query("page") page: Int = 1
    ) : Response<ArticleList>

}