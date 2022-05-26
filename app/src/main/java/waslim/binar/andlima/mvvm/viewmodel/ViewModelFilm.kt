package waslim.binar.andlima.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import waslim.binar.andlima.mvvm.model.GetAllFilmResponseItem
import waslim.binar.andlima.mvvm.network.ApiService
import javax.inject.Inject

@HiltViewModel
class ViewModelFilm @Inject constructor(apiService : ApiService) : ViewModel(){

    private var filmLiveData = MutableLiveData<List<GetAllFilmResponseItem>>()

    val film : LiveData<List<GetAllFilmResponseItem>> = filmLiveData

    init {
        viewModelScope.launch {
            val datafilm = apiService.getALlFilm()
            delay(1000)
            filmLiveData.value = datafilm
        }
    }


}