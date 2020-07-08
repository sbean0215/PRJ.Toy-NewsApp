package beans.prj.newsapp.ui.splash

import android.content.Intent
import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.ActivitySplashBinding
import beans.prj.newsapp.ui.base.BaseActivity
import beans.prj.newsapp.ui.home.HomeActivity

class SplashActivity : BaseActivity<ActivitySplashBinding?>() {
    override fun initViewOnCreat() {
        openHomeActivity()
    }

    override val layoutId: Int
        get() = R.layout.activity_splash

    fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}