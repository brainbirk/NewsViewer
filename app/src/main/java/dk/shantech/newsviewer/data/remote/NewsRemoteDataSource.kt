package dk.shantech.newsviewer.data.remote

import android.util.Log
import dk.shantech.newsviewer.data.model.ArticleList
import dk.shantech.newsviewer.data.model.ErrorResponse
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import dk.shantech.newsviewer.data.model.Result
import java.io.IOException

class NewsRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun fetchNews(): Result<ArticleList> {
        val newsService = retrofit.create(NewsService::class.java)
        return getResponse(
            request = { newsService.getAllNews() },
            defaultErrorMessage = "Error fetching Movie Description")
    }

    suspend fun searchNews(query:String): Result<ArticleList> {
        val newsService = retrofit.create(NewsService::class.java)
        return getResponse(
            request = { newsService.getSearchNews(query = query) },
            defaultErrorMessage = "Error fetching Movie Description")
    }


    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                Log.d("Here", "getResponse: result: ${result.errorBody()}")
                val errorResponse = parseError(result, retrofit)
                Log.d("Here", "getResponse: errorResponse: $errorResponse")
                Result.error(errorResponse?.message?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Log.e("Here", "getResponse: Error", e)
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