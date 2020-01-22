package beans.prj.newsapp.data.service;

import beans.prj.newsapp.data.model.News;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface APIService {

    @GET("v2/top-headlines")
    Observable<News> getTopHeadlines(@QueryMap Map<String, String> options);







    /* TEST */
    @GET("v2/top-headlines")
    Call<News> getTopHeadlinesForTest(@QueryMap Map<String, String> options);
}
