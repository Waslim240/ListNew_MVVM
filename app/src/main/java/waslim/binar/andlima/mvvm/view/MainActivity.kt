package waslim.binar.andlima.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.adapter.AdapterNews
import waslim.binar.andlima.mvvm.viewmodel.ViewModelNews

class MainActivity : AppCompatActivity() {

    lateinit var newsadapter : AdapterNews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsadapter = AdapterNews()
        initRecycler()
    }

    private fun initRecycler(){
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsadapter
        initViewModel()
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)

        viewModel.liveGetDataNews().observe(this, Observer {
            if (it != null){
                newsadapter.setNewList(it)
                newsadapter.notifyDataSetChanged()
            }
        })

        viewModel.getDataNews()
    }

}