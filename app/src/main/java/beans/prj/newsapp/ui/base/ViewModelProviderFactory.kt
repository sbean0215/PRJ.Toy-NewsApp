package beans.prj.newsapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import beans.prj.newsapp.data.AppRepository
import java.lang.reflect.InvocationTargetException

class ViewModelProviderFactory(var repository: AppRepository?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = /*if (ViewModel::class.java.isAssignableFrom(modelClass)) */
            modelClass.getConstructor(AppRepository::class.java).newInstance(repository)
    /* else null*/
}