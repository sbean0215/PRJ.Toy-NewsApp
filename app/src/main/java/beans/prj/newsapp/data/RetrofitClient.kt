package beans.prj.newsapp.data

import android.content.Context
import android.util.Log
import beans.prj.newsapp.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitClient {
    private const val BASE_API = "https://newsapi.org/"
    private var retrofit: Retrofit? = null
    @JvmStatic
    fun getRetrofitInstance(context: Context): Retrofit? {
        val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("BEAN", "OkHttp$message")
            }
        })
//        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val okhttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(RequestInterceptor(context))
                .addInterceptor(logging)
                .build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .client(okhttpClient)
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
        return retrofit
    }

    internal class RequestInterceptor(var context: Context) : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                    .header("X-Api-Key", context.getString(R.string.news_api_key))
                    .build()

//            Log.d("TEST_INTERCEPT", newRequest.toString());
//            Log.d("TEST_INTERCEPT", "Authentication  :: " + newRequest.header("X-Api-Key"));
            return chain.proceed(newRequest)
        }

    }
}