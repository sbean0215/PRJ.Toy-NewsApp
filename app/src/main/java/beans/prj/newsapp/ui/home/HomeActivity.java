package beans.prj.newsapp.ui.home;

import beans.prj.newsapp.R;
import beans.prj.newsapp.databinding.ActivityHomeBinding;
import beans.prj.newsapp.ui.base.BaseActivity;


public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initViewOnCreat() {
        binding.vpCategory.setAdapter(new CategoryVpAdapter(getSupportFragmentManager()));
        binding.tabLayoutCategories.setupWithViewPager(binding.vpCategory);
    }
}
