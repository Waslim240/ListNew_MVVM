package waslim.binar.andlima.mvvm.network

import retrofit2.Call
import retrofit2.http.GET
import waslim.binar.andlima.mvvm.model.GetAllFilmResponseItem
import waslim.binar.andlima.mvvm.model.GetAllNewsItem

interface ApiService {

    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsItem>

    @GET("film")
    suspend fun getALlFilm() : List<GetAllFilmResponseItem>

}