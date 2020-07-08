package beans.prj.newsapp.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel>
    :  AppCompatDialogFragment(), HasAndroidInjector
{

    abstract var viewModelFactory: ViewModelProviderFactory

    abstract var binding: DB
    abstract var sharedViewModel: VM
    abstract var fragmentTitle: String?

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

}