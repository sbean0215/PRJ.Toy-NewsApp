package beans.prj.newsapp.data;

import android.util.Log;
import beans.prj.newsapp.data.model.News;
import beans.prj.newsapp.data.service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import javax.inject.Inject;
import java.util.HashMap;

public class AppRepository {

    private APIService apiService;

    @Inject
    public AppRepository(Retrofit retrofit){
        apiService = retrofit.create(APIService.class);
    }

    public void testCall() {
        HashMap<String, String> option = new HashMap<>();
        option.put("country", "kr");

        Call<News> call = apiService.getTopHeadlinesForTest(option);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i("BEAN", "onFailure"+ t.getMessage());
            }
        });
    }

}
