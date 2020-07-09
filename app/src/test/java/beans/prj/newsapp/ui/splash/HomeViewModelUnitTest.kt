package beans.prj.newsapp.ui.splash

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import beans.prj.newsapp.MockNewsApplication
import beans.prj.newsapp.data.AppRepository
import beans.prj.newsapp.ui.home.HomeActivity
import beans.prj.newsapp.ui.home.HomeActivityViewModel
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot
import org.hamcrest.core.IsNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
//@RunWith(MockitoJUnitRunner::class)
class HomeViewModelUnitTest {

    @get:Rule var mockitoRule = MockitoJUnit.rule()

    @Mock lateinit var repository: AppRepository

    lateinit var homeViewModel : HomeActivityViewModel


    @Before
    fun initialize() {

        MockitoAnnotations.initMocks(this)
        homeViewModel = HomeActivityViewModel(repository)
    }

    @Test
    fun `결과 테스트`() {
//        homeViewModel.addfuntion(1,2).run {
//            assertThat(this, IsEqual(3))
//        }
    }


}