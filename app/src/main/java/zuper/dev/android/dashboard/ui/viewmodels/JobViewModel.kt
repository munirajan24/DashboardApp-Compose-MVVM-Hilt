package zuper.dev.android.dashboard.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import zuper.dev.android.dashboard.data.DataRepository
import zuper.dev.android.dashboard.data.model.JobApiModel
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _jobsState = MutableLiveData<List<JobApiModel>?>(null)
    val jobsState: LiveData<List<JobApiModel>?> = _jobsState

    init {
        fetchJobs()
    }

    fun refreshJobs() {
        fetchJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            _jobsState.value = dataRepository.getJobs()
        }
    }
}