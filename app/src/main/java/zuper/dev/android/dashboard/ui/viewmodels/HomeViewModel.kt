package zuper.dev.android.dashboard.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import zuper.dev.android.dashboard.data.DataRepository
import zuper.dev.android.dashboard.data.model.InvoiceApiModel
import zuper.dev.android.dashboard.data.model.JobApiModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _jobsState = MutableLiveData<List<JobApiModel>?>(null)
    val jobsState: LiveData<List<JobApiModel>?> = _jobsState

    private val _invoicesState = MutableLiveData<List<InvoiceApiModel>?>(null)
    val invoicesState: LiveData<List<InvoiceApiModel>?> = _invoicesState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            dataRepository.observeJobs().collect { jobsList ->
                _jobsState.value = jobsList
            }
        }
        viewModelScope.launch {
            dataRepository.observeInvoices().collect { invoicesList ->
                _invoicesState.value = invoicesList
            }
        }
    }
}