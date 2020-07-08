package beans.prj.newsapp.di

import beans.prj.newsapp.ui.home.HomeActivity
import beans.prj.newsapp.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity?

    @ContributesAndroidInjector(modules = [NewsFragBuilder::class])
    abstract fun bindHomeActivity(): HomeActivity?
}