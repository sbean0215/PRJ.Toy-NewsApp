package beans.prj.newsapp.di;

import android.content.Context;
import beans.prj.newsapp.NewsApplication;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(NewsApplication application) {
        return application;
    }

}
