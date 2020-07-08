package beans.prj.newsapp.ui.splash

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import beans.prj.newsapp.MockNewsApplication
import beans.prj.newsapp.ui.home.HomeActivity
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot
import org.hamcrest.core.IsNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = MockNewsApplication::class)
class HomeActivityUnitTest {

    @get:Rule var activityScenarioRule = ActivityScenarioRule(HomeActivity::class.java)


    @Test
    fun `멤버변수 null 테스트`() {
        activityScenarioRule.scenario.onActivity { homeActivity ->
            assertThat(homeActivity, IsNot(IsNull()))
            assertThat(homeActivity.binding, IsNot(IsNull()))
            assertThat(homeActivity.viewModel, IsNot(IsNull()))
        }

    }


}