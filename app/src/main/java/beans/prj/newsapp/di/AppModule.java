package beans.prj.newsapp.di;

import android.content.Context;
import beans.prj.newsapp.NewsApplication;
import beans.prj.newsapp.ui.base.ViewModelProviderFactory;
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

    @Singleton
    @Provides
    ViewModelProviderFactory provideViewModelProviderFactory() {
        return new ViewModelProviderFactory();
    }

}
