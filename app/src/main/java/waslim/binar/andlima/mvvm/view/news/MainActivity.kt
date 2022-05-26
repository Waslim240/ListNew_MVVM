package waslim.binar.andlima.mvvm.view.news

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.adapter.AdapterNews
import waslim.binar.andlima.mvvm.viewmodel.ViewModelNews

@SuppressLint("NotifyDataSetChanged")
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataNews()
        goToFavorite()
    }

    private fun getDataNews(){
        val newsAdapter = AdapterNews(){
            val pdh = Intent(this, DetailActivity::class.java)
            pdh.putExtra("detailnews", it)
            startActivity(pdh)
        }

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter

        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)

        viewModel.news.observe(this){
            if (it != null){
                newsAdapter.setNewList(it)
                newsAdapter.notifyDataSetChanged()
            }
        }

    }

    private fun goToFavorite(){
        keFavorite.setOnClickListener {
            startActivity(Intent(this, Favorite::class.java))
        }
    }

//======================================= TANPA DI //==============================================//

//    private fun initRecycler(){
//        rv_news.layoutManager = LinearLayoutManager(this)
//        rv_news.adapter = newsadapter
//        initViewModel()
//    }
//
//    private fun initViewModel(){
//        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
//
//        viewModel.liveGetDataNews().observe(this, Observer {
//            if (it != null){
//                newsadapter.setNewList(it)
//                newsadapter.notifyDataSetChanged()
//            }
//        })
//
//        viewModel.getDataNews()
//    }

}