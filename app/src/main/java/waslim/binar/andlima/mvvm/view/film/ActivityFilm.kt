package waslim.binar.andlima.mvvm.view.film

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_film.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.adapter.AdapterFilm
import waslim.binar.andlima.mvvm.viewmodel.ViewModelFilm

@SuppressLint("NotifyDataSetChanged")
@AndroidEntryPoint
class ActivityFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        getDataFilm()
    }

    private fun getDataFilm(){
        val adapterFilm = AdapterFilm(){
            val pdh = Intent(this, DetailFilm::class.java)
            pdh.putExtra("detailfilm", it)
            startActivity(pdh)
        }

        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = adapterFilm

        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)

        viewModel.film.observe(this){
            if (it != null){
                adapterFilm.setDataFilm(it)
                adapterFilm.notifyDataSetChanged()
            }
        }

    }

}