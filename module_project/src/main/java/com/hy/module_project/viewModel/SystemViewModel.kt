package com.hy.module_project.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy.commom.network.BaseResult
import com.hy.module_project.bean.SystemDataItem
import com.hy.module_project.repository.ProjectRepository
import kotlinx.coroutines.launch

class SystemViewModel: ViewModel() {
	val systems = MutableLiveData<List<SystemDataItem>?>()
	private val  projectRepository by lazy { ProjectRepository() }

	fun fetchSystems() {
		viewModelScope.launch {
			when(val result = projectRepository.fetchSystems()) {
				is BaseResult.Success -> {
					systems.postValue(result.data)
				}
				is BaseResult.Error	-> {

				}
			}
		}
	}
}