package beans.prj.newsapp.data;

import android.content.Context;
import android.util.Log;
import beans.prj.newsapp.R;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitClient {

    private static String BASE_API = "https://newsapi.org/";
    private static Retrofit retrofit ;

    public static Retrofit getRetrofitInstance(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
                Log.d("BEAN","OkHttp" + message);
            }
        });
        logging.setLevel(Level.BASIC);

        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new RequestInterceptor(context))
                .addInterceptor(logging)
                .build();

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(okhttpClient)
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    final static class RequestInterceptor implements Interceptor {

        Context context;

        public RequestInterceptor(Context context) {
            this.context = context;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Request newRequest = originalRequest.newBuilder()
                    .header("X-Api-Key", context.getString(R.string.news_api_key))
                    .build();

//            Log.d("TEST_INTERCEPT", newRequest.toString());
//            Log.d("TEST_INTERCEPT", "Authentication  :: " + newRequest.header("X-Api-Key"));

            return chain.proceed(newRequest);
        }
    }

}
