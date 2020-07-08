package beans.prj.newsapp.ui.splash

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import beans.prj.newsapp.MockNewsApplication
import beans.prj.newsapp.ui.home.HomeActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = MockNewsApplication::class)
class SplashActivityUnitTest {

    @get:Rule var activityScenarioRule = ActivityScenarioRule(SplashActivity::class.java)


    @Test
    fun `Splash START 및 Splash DESTROY 테스트`() {
        assertThat(activityScenarioRule.scenario.state, Is(CoreMatchers.equalTo(Lifecycle.State.DESTROYED)))

        Shadows.shadowOf(ApplicationProvider.getApplicationContext<Application>()).run {
            assertThat(nextStartedActivity.component?.className, CoreMatchers.equalTo(HomeActivity::class.java.name))
        }
    }

}