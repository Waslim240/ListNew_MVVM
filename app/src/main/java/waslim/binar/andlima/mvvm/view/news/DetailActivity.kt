package waslim.binar.andlima.mvvm.view.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.local.News
import waslim.binar.andlima.mvvm.local.NewsDatabase
import waslim.binar.andlima.mvvm.model.GetAllNewsItem

class DetailActivity : AppCompatActivity() {
    private var dB : NewsDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        dB = NewsDatabase.getInstance(this)

        getDataDetail()
        addAndDelete()
    }

    private fun getDataDetail(){
        val detailNews = intent.getParcelableExtra<GetAllNewsItem>("detailnews")

        Glide.with(applicationContext).load(detailNews?.image).into(imageView_detail)
        title_detail.text = detailNews?.title
        createDate_detail.text = detailNews?.createdAt
        author_detail.text = detailNews?.author
        description.text = detailNews?.description
    }


    private fun addAndDelete(){
        btn_fav.setOnClickListener {
            val detailNews = intent.getParcelableExtra<GetAllNewsItem>("detailnews")

            GlobalScope.async {
                if (detailNews != null) {
                    val addFavorite = dB?.newsDao()?.insertNews(News(null, detailNews.createdAt, detailNews.description, detailNews.author,
                    detailNews.image, detailNews.title))
                    runOnUiThread {
                        if (addFavorite != 0.toLong()){
                            Toast.makeText(this@DetailActivity, "Berhasil Menambahkan Ke Favorite", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this@DetailActivity, "Gagal Menambahkan Ke Favorite", Toast.LENGTH_LONG).show()

                        }
                    }
                }
            }
        }
    }

}