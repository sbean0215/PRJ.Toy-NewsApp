package beans.prj.newsapp.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.ActivityHomeBinding
import beans.prj.newsapp.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var viewModel : HomeActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.apply {
            vpCategory.adapter = CategoryVpAdapter(supportFragmentManager)
            tabLayoutCategories.setupWithViewPager(vpCategory)

            executePendingBindings()
        }


    }
}