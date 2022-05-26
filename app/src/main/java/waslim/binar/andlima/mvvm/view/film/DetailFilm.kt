package waslim.binar.andlima.mvvm.view.film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.description
import kotlinx.android.synthetic.main.activity_detail_film.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.model.GetAllFilmResponseItem
import waslim.binar.andlima.mvvm.model.GetAllNewsItem

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        getDataDetail()
    }

    private fun getDataDetail(){
        val detailNews = intent.getParcelableExtra<GetAllFilmResponseItem>("detailfilm")

        Glide.with(applicationContext).load(detailNews?.image).into(imageFilmDetail)
        tvJudulDetail.text = detailNews?.name
        tvTglRilisDetail.text = detailNews?.date
        tvSutradaraDetail.text = detailNews?.director
        description.text = detailNews?.description
    }
}