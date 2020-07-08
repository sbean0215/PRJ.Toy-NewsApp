package beans.prj.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.FragmentNewsListBinding
import beans.prj.newsapp.etc.Constants
import beans.prj.newsapp.ui.base.BaseFragment
import beans.prj.newsapp.ui.base.ViewModelProviderFactory
import javax.inject.Inject

class NewsListFragment : BaseFragment<FragmentNewsListBinding, HomeActivityViewModel>() {

    @Inject
    override lateinit var viewModelFactory: ViewModelProviderFactory

    override lateinit var binding: FragmentNewsListBinding
    override lateinit var sharedViewModel: HomeActivityViewModel

    override var fragmentTitle: String? = null
        get() = arguments?.getString(Constants.TITLE)



    companion object {
        fun newInstance(title: String?): NewsListFragment {
            val args = Bundle()
            args.putString(Constants.TITLE, title)
            val fragment = NewsListFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        sharedViewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(HomeActivityViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = sharedViewModel
            rvNewsList.layoutManager = LinearLayoutManager(context)
        }
    }
}