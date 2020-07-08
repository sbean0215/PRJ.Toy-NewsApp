package beans.prj.newsapp

import beans.prj.newsapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NewsApplication : DaggerApplication() {
        override fun applicationInjector(): AndroidInjector<NewsApplication?>?
                = DaggerAppComponent.builder().create(this)
}