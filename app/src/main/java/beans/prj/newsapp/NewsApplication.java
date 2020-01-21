package beans.prj.newsapp;

import dagger.android.DaggerApplication;
import dagger.android.AndroidInjector;
import beans.prj.newsapp.di.DaggerAppComponent;

public class NewsApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}
