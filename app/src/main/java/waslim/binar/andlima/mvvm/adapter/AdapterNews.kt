package waslim.binar.andlima.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.model.GetAllNewsItem

class AdapterNews(private val onClick : (GetAllNewsItem) -> Unit) : RecyclerView.Adapter<AdapterNews.ViewHolder> () {

    private var dataNews : List<GetAllNewsItem>? = null

    fun setNewList(newsList :List<GetAllNewsItem> ) {
        this.dataNews = newsList
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNews.ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterNews.ViewHolder, position: Int) {
        holder.itemView.title.text = dataNews!![position].title
        holder.itemView.createDate.text = dataNews!![position].createdAt
        holder.itemView.author.text = dataNews!![position].author
        Glide.with(holder.itemView.context).load(dataNews!![position].image).into(holder.itemView.imageView)

        holder.itemView.cardNews.setOnClickListener {
            onClick(dataNews!![position])
        }

    }

    override fun getItemCount(): Int {
        return when (dataNews) {
            null -> {
                0
            }
            else -> {
                dataNews!!.size
            }
        }
    }

}