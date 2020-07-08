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

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    abstract var viewModelFactory: ViewModelProviderFactory

    abstract var binding: DB
    abstract var sharedViewModel: VM
    abstract var fragmentTitle: String?


}