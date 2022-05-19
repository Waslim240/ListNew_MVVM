package waslim.binar.andlima.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.mvvm.model.GetAllNewsItem
import waslim.binar.andlima.mvvm.network.ApiClient

class ViewModelNews : ViewModel(){

    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsItem>?>

    init {
        liveDataNews = MutableLiveData()
    }

    fun liveGetDataNews() : MutableLiveData<List<GetAllNewsItem>?>{
        return liveDataNews
    }

    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsItem>>,
                    response: Response<List<GetAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    } else {
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}