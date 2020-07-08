package beans.prj.newsapp.di

import beans.prj.newsapp.NewsApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class]
)
interface AppComponent : AndroidInjector<NewsApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<NewsApplication>
}