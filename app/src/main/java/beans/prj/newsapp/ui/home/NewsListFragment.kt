package beans.prj.newsapp.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import beans.prj.newsapp.R
import beans.prj.newsapp.databinding.FragmentNewsListBinding
import beans.prj.newsapp.etc.Constants
import beans.prj.newsapp.ui.base.BaseFragment

class NewsListFragment : BaseFragment<FragmentNewsListBinding?, HomeActivityViewModel>() {
    private var fragmentTitle: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentTitle = arguments!!.getString(Constants.TITLE)
    }

    override fun initViews() {
        binding!!.viewModel = sharedViewModel
        binding!!.rvNewsList.layoutManager = LinearLayoutManager(context)
    }

    override val fragLayoutId: Int
        get() = R.layout.fragment_news_list

    override fun initSharedViewModel(): HomeActivityViewModel {
        return ViewModelProviders.of(activity!!, viewModelFactory).get(HomeActivityViewModel::class.java)
    }

    companion object {
        fun newInstance(title: String?): NewsListFragment {
            val args = Bundle()
            args.putString(Constants.TITLE, title)
            val fragment = NewsListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}