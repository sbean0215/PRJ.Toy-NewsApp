package beans.prj.newsapp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import beans.prj.newsapp.R;
import beans.prj.newsapp.databinding.FragmentNewsListBinding;
import beans.prj.newsapp.etc.Constants;
import beans.prj.newsapp.ui.base.BaseFragment;


public class NewsListFragment extends BaseFragment<FragmentNewsListBinding, HomeActivityViewModel> {

    private String fragmentTitle;

    public static NewsListFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(Constants.TITLE, title);

        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentTitle = getArguments().getString(Constants.TITLE);
    }

    @Override
    public void initViews() {
        binding.setViewModel(getSharedViewModel());
        binding.rvNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public int getFragLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    public HomeActivityViewModel getSharedViewModel() {
        return ViewModelProviders.of(activity, viewModelFactory).get(HomeActivityViewModel.class);
    }

}
