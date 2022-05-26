package waslim.binar.andlima.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import waslim.binar.andlima.mvvm.model.GetAllNewsItem
import waslim.binar.andlima.mvvm.network.ApiService
import javax.inject.Inject

@HiltViewModel
class ViewModelNews @Inject constructor(apiService : ApiService) : ViewModel(){

    private var newsLiveData = MutableLiveData<List<GetAllNewsItem>>()

    val news : LiveData<List<GetAllNewsItem>?> = newsLiveData

    init {
        viewModelScope.launch {
            val datanews = apiService.getAllNews()
            delay(1000)
            newsLiveData.value = datanews
        }
    }



//======================================= TANPA DI ================================================//
//    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsItem>?>
//
//    init {
//        liveDataNews = MutableLiveData()
//    }
//
//    fun liveGetDataNews() : MutableLiveData<List<GetAllNewsItem>?>{
//        return liveDataNews
//    }
//
//    fun getDataNews(){
//        ApiClient.instance.getAllNews()
//            .enqueue(object : Callback<List<GetAllNewsItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllNewsItem>>,
//                    response: Response<List<GetAllNewsItem>>
//                ) {
//                    if (response.isSuccessful){
//                        liveDataNews.postValue(response.body())
//                    } else {
//                        liveDataNews.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
//                    liveDataNews.postValue(null)
//                }
//
//            })
//    }

}