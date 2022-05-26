package waslim.binar.andlima.mvvm.view.news

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_favorite.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.adapter.AdapterNewsFavorite
import waslim.binar.andlima.mvvm.viewmodel.ViewModelFavorite

@SuppressLint("NotifyDataSetChanged")
@AndroidEntryPoint
class Favorite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        getDataFavorite()
    }

    private fun getDataFavorite(){
        val favAdapter = AdapterNewsFavorite(){}

        rv_newsFav.layoutManager = LinearLayoutManager(this)
        rv_newsFav.adapter = favAdapter

        val viewModel = ViewModelProvider(this).get(ViewModelFavorite::class.java)

        viewModel.newsFavorite.observe(this){
            if ( it != null){
                favAdapter.setNewListFav(it)
                favAdapter.notifyDataSetChanged()
            }
        }
    }


}