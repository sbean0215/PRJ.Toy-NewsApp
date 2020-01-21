package beans.prj.newsapp.data;

import beans.prj.newsapp.data.service.APIService;
import retrofit2.Retrofit;
import javax.inject.Inject;

public class AppRepository {

    private APIService apiService;

    @Inject
    public AppRepository(Retrofit retrofit){
        apiService = retrofit.create(APIService.class);
    }

}
