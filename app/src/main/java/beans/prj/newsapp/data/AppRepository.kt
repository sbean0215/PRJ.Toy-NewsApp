package beans.prj.newsapp.data

import android.util.Log
import beans.prj.newsapp.data.model.News
import beans.prj.newsapp.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class AppRepository @Inject constructor(retrofit: Retrofit) {
    private val apiService: APIService
    fun testCall() {
        val option = HashMap<String, String>()
        option["country"] = "kr"
        val call = apiService.getTopHeadlinesForTest(option)
        call!!.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {}
            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.i("BEAN", "onFailure" + t.message)
            }
        })
    }

    init {
        apiService = retrofit.create(APIService::class.java)
    }
}