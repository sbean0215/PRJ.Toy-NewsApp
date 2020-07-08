package beans.prj.newsapp.ui.base

import androidx.lifecycle.ViewModel
import beans.prj.newsapp.data.AppRepository

abstract class BaseViewModel(private val repository: AppRepository) : ViewModel()