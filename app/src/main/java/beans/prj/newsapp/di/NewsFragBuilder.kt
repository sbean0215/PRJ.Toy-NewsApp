package beans.prj.newsapp.di

import beans.prj.newsapp.ui.home.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsFragBuilder {
    @ContributesAndroidInjector
    abstract fun bindNewsListFragment(): NewsListFragment?
}