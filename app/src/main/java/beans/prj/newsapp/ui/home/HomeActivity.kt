package beans.prj.newsapp.ui.home

import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.ActivityHomeBinding
import beans.prj.newsapp.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding?>() {
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun initViewOnCreat() {
        binding!!.vpCategory.adapter = CategoryVpAdapter(supportFragmentManager)
        binding!!.tabLayoutCategories.setupWithViewPager(binding!!.vpCategory)
    }
}