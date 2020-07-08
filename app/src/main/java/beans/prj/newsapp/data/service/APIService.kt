package beans.prj.newsapp.data.service

import beans.prj.newsapp.data.model.News
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface APIService {
    @GET("v2/top-headlines")
    fun getTopHeadlines(@QueryMap options: Map<String?, String?>?): Observable<News?>?

    /* TEST */
    @GET("v2/top-headlines")
    fun getTopHeadlinesForTest(@QueryMap options: Map<String, String>?): Call<News?>?
}