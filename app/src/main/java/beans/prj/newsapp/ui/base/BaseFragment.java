package beans.prj.newsapp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;

public abstract class BaseFragment <DB extends ViewDataBinding,  VM extends BaseViewModel> extends DaggerFragment {

    @Inject public ViewModelProviderFactory viewModelFactory;

    protected BaseActivity activity;
    protected DB binding;
    protected VM sharedViewModel;

    public abstract void initViews();
    public abstract int getFragLayoutId();
    public abstract VM getSharedViewModel();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getFragLayoutId(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = getSharedViewModel();
        initViews();
    }

    @Override
    public void onDetach() {
        activity = null;
        super.onDetach();
    }


}
