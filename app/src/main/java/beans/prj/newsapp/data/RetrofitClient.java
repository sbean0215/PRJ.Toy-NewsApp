package beans.prj.newsapp.data;

import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static String BASE_API = "https://newsapi.org/";
    private static Retrofit retrofit ;

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
                Log.d("BEAN","OkHttp" + message);
            }
        });
        logging.setLevel(Level.BASIC);

        OkHttpClient okhttpClient = new OkHttpClient.Builder().addInterceptor(logging)
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
}
