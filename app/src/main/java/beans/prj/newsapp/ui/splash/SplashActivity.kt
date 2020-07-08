package beans.prj.newsapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.ActivitySplashBinding
import beans.prj.newsapp.ui.base.BaseActivity
import beans.prj.newsapp.ui.home.HomeActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override lateinit var binding: ActivitySplashBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        openHomeActivity()
    }


    fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}