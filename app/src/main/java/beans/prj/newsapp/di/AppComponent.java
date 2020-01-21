package beans.prj.newsapp.di;

import beans.prj.newsapp.NewsApplication;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component ( modules = {AndroidSupportInjectionModule.class
        , AppModule.class
        , ActivityBuilder.class} )
public interface AppComponent extends AndroidInjector<NewsApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<NewsApplication> {}
}
