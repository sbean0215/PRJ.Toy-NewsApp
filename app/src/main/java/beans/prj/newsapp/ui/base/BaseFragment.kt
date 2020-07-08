package beans.prj.newsapp.ui.base

import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    abstract var viewModelFactory: ViewModelProviderFactory

    abstract var binding: DB
    abstract var sharedViewModel: VM
    abstract var fragmentTitle: String?


}