package dk.shantech.newsviewer.data.remote

import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.ArticleSourceList
import dk.shantech.newsviewer.data.model.ErrorResponse
import dk.shantech.newsviewer.data.model.Result
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun fetchNews(query: String = "",
                          qInTitle: String = "",
                          sources: String = "",
                          domains: String = "",
                          excludeDomains: String = "",
                          from: String = "",
                          to: String = "",
                          language: String = "",
                          sortBy: String = "",
                          pageSize: Int = 100,
                          page: Int = 1
    ): Result<ArticleList> {
        val newsService = retrofit.create(NewsService::class.java)
        return getResponse(
            request = { newsService.getAllNews(
                query = query,
                qInTitle = qInTitle,
                sources = sources,
                domains = domains,
                excludeDomains = excludeDomains,
                from = from,
                to = to,
                language = language,
                sortBy = sortBy,
                pageSize = pageSize,
                page = page
            ) },
            defaultErrorMessage = "Error fetching News")
    }

    suspend fun fetchTopHeadlines(country: String = "",
                                  category: String = "",
                                  sources: String = "",
                                  query: String = "",
                                  pageSize: Int = 20,
                                  page: Int = 1
    ): Result<ArticleList> {
        val newsService = retrofit.create(NewsService::class.java)
        return getResponse(
            request = { newsService.getHeadlines(
                country = country,
                category = category,
                sources = sources,
                query = query,
                pageSize = pageSize,
                page = page
            ) },
            defaultErrorMessage = "Error fetching Headlines")
    }

    suspend fun fetchSources(category: String = "",
                             language: String = "",
                             country: String = ""
    ): Result<ArticleSourceList> {
        val newsService = retrofit.create(NewsService::class.java)
        return getResponse(
            request = { newsService.getSources(
                category = category,
                language = language,
                country = country
            ) },
            defaultErrorMessage = "Error fetching News sources")
    }


    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = parseError(result, retrofit)
                Result.error(errorResponse?.message?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }

    private fun parseError(response: Response<*>, retrofit: Retrofit): ErrorResponse? {
        val converter = retrofit.responseBodyConverter<ErrorResponse>(ErrorResponse::class.java, arrayOfNulls(0))
        return try {
            converter.convert(response.errorBody()!!)
        } catch (e: IOException) {
            ErrorResponse("error","Title", "error")
        }
    }

}