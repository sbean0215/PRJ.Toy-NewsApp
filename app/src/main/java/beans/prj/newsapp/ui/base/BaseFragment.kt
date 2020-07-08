package beans.prj.newsapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<DB : ViewDataBinding?, VM : BaseViewModel?> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    protected var activity: BaseActivity<*>? = null
    protected var binding: DB? = null

    abstract fun initViews()
    abstract val fragLayoutId: Int

    protected var sharedViewModel: VM? = null
    abstract fun initSharedViewModel(): VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            this.activity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<DB>(inflater, fragLayoutId, container, false)
        return binding?.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = initSharedViewModel()
        initViews()
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }
}