package beans.prj.newsapp.ui.base;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<DB extends ViewDataBinding> extends DaggerAppCompatActivity {

    protected DB binding;

    public abstract int getLayoutId();
    public abstract void initViewOnCreat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initViewOnCreat();
        binding.executePendingBindings();
    }


    protected void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);   //앱 이름 사용 설정 false
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
