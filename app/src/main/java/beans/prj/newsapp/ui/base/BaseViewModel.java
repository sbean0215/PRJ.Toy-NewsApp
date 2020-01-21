package beans.prj.newsapp.ui.base;

import androidx.lifecycle.ViewModel;
import beans.prj.newsapp.data.AppRepository;

public abstract class BaseViewModel extends ViewModel {

    private AppRepository repository;

    public BaseViewModel(AppRepository repository) {
        this.repository = repository;
    }
}
