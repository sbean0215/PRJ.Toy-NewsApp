package beans.prj.newsapp.di;

import android.content.Context;
import beans.prj.newsapp.NewsApplication;
import beans.prj.newsapp.data.AppRepository;
import beans.prj.newsapp.data.RetrofitClient;
import beans.prj.newsapp.ui.base.ViewModelProviderFactory;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(NewsApplication application) {
        return application;
    }

    @Singleton
    @Provides
    ViewModelProviderFactory provideViewModelProviderFactory(AppRepository repository) {
        return new ViewModelProviderFactory(repository);
    }

    @Singleton
    @Provides
    Retrofit provideReprofit(){
        return RetrofitClient.getRetrofitInstance();
    }

    @Singleton
    @Provides
    AppRepository provideAppRepository(Retrofit retrofit) {
        return new AppRepository(retrofit);
    }

}
