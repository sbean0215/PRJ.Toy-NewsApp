package beans.prj.newsapp.di

import beans.prj.newsapp.MockNewsApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    MockAppModule::class,
    MockNetworkModule::class,
    MockActivityBuilder::class,
    MockFragmentBuilder::class]
)
interface MockAppComponent : AndroidInjector<MockNewsApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MockNewsApplication>
}