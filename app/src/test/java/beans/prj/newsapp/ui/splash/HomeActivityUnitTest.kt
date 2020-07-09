package beans.prj.newsapp.ui.splash

import androidx.core.view.get
import androidx.core.view.size
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.viewpager.widget.ViewPager
import beans.prj.newsapp.MockNewsApplication
import beans.prj.newsapp.etc.Categories
import beans.prj.newsapp.ui.home.HomeActivity
import com.google.android.material.tabs.TabLayout
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot
import org.hamcrest.core.IsNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf
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

    @Test
    fun `탭 및 뷰페이저 확인`() {
        val scenario = activityScenarioRule.scenario
        var tabLayout : TabLayout? = null
        var viewPager : ViewPager? = null

        scenario.onActivity {
            tabLayout = it.binding.tabLayoutCategories
            viewPager = it.binding.vpCategory

            assertThat(tabLayout?.tabCount, IsEqual(6)) //Categories count
            assertThat(viewPager?.size, IsEqual(2)) //초기 값
        }
    }


}