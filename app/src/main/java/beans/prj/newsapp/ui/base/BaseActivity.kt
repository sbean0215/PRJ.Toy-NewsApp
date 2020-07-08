package beans.prj.newsapp.ui.base

import android.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<DB : ViewDataBinding?> : DaggerAppCompatActivity() {

    protected var binding: DB? = null
    abstract val layoutId: Int

    abstract fun initViewOnCreat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        binding = DataBindingUtil.setContentView<DB>(this, layoutId)
        initViewOnCreat()
        binding?.executePendingBindings()
    }

    protected fun setToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayShowTitleEnabled(false) //앱 이름 사용 설정 false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}