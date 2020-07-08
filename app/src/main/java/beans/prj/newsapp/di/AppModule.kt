package beans.prj.newsapp.di

import android.content.Context
import beans.prj.newsapp.NewsApplication
import beans.prj.newsapp.data.AppRepository
import beans.prj.newsapp.data.RetrofitClient.getRetrofitInstance
import beans.prj.newsapp.ui.base.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: NewsApplication): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideViewModelProviderFactory(repository: AppRepository?): ViewModelProviderFactory {
        return ViewModelProviderFactory(repository)
    }

    @Singleton
    @Provides
    fun provideReprofit(context: Context?): Retrofit? {
        return getRetrofitInstance(context!!)
    }

    @Singleton
    @Provides
    fun provideAppRepository(retrofit: Retrofit?): AppRepository {
        return AppRepository(retrofit!!)
    }
}