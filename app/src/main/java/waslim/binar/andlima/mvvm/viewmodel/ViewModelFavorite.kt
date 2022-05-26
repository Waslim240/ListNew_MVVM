package waslim.binar.andlima.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import waslim.binar.andlima.mvvm.local.News
import waslim.binar.andlima.mvvm.local.NewsDao
import waslim.binar.andlima.mvvm.local.NewsDatabase
import javax.inject.Inject

@HiltViewModel
class ViewModelFavorite @Inject constructor(newsDao: NewsDao) : ViewModel(){

    private var newsLiveDataFavorite = MutableLiveData<List<News>>()

    val newsFavorite : LiveData<List<News>> = newsLiveDataFavorite

    init {
        viewModelScope.launch{
            val dataFavorite = newsDao.getNews()
            newsLiveDataFavorite.value = dataFavorite
        }
    }




}