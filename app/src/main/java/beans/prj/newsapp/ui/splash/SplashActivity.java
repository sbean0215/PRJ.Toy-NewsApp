package beans.prj.newsapp.ui.splash;

import android.content.Intent;
import beans.prj.newsapp.R;
import beans.prj.newsapp.databinding.ActivitySplashBinding;
import beans.prj.newsapp.ui.base.BaseActivity;
import beans.prj.newsapp.ui.home.HomeActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    @Override
    public void initViewOnCreat() {
        openHomeActivity();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        finish();
    }
}
