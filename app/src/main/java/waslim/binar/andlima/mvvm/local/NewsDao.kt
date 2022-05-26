package waslim.binar.andlima.mvvm.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert
    fun insertNews(news: News) : Long

    @Query("SELECT * FROM News")
    fun getNews() : List<News>

    @Query("DELETE FROM News WHERE id = :id ")
    fun deleteNews(id: Int)
}