package beans.prj.newsapp.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import beans.prj.newsapp.data.AppRepository;

import java.lang.reflect.InvocationTargetException;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    AppRepository repository;

    public ViewModelProviderFactory(AppRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (ViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(AppRepository.class).newInstance(repository);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            }
        }
        return null;
    }
}
