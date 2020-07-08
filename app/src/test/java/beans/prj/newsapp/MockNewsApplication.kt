package beans.prj.newsapp

import beans.prj.newsapp.di.DaggerMockAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MockNewsApplication : DaggerApplication() {

        override fun applicationInjector(): AndroidInjector<out DaggerApplication>
                = DaggerMockAppComponent.factory().create(this)
}