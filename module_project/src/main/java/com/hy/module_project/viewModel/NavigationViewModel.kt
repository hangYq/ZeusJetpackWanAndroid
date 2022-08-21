package com.hy.module_project.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy.commom.network.BaseResult
import com.hy.module_project.bean.NavigationData
import com.hy.module_project.repository.ProjectRepository
import kotlinx.coroutines.launch

class NavigationViewModel:ViewModel() {
	val navigationList  = MutableLiveData<List<NavigationData>?>()
	private val  projectRepository by lazy { ProjectRepository() }

	fun fetchNavigation() {
		viewModelScope.launch {
			when(val result = projectRepository.fetchNavigation()) {
				is BaseResult.Success -> {
					navigationList.postValue(result.data)
				}
				is BaseResult.Error	-> {

				}
			}
		}
	}
}