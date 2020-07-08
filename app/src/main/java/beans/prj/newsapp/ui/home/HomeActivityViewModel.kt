package beans.prj.newsapp.ui.home

import beans.prj.newsapp.data.AppRepository
import beans.prj.newsapp.ui.base.BaseViewModel
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(repository: AppRepository)
    : BaseViewModel(repository){

}