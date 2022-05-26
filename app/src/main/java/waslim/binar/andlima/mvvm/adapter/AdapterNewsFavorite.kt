package waslim.binar.andlima.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news_favorite.view.author
import kotlinx.android.synthetic.main.item_news_favorite.view.createDate
import kotlinx.android.synthetic.main.item_news_favorite.view.imageView
import kotlinx.android.synthetic.main.item_news_favorite.view.title
import kotlinx.android.synthetic.main.item_news_favorite.view.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.local.News

class AdapterNewsFavorite(private val onClick : (News) -> Unit) : RecyclerView.Adapter<AdapterNewsFavorite.ViewHolder> () {

    private var dataNewsFavorite : List<News>? = null

    fun setNewListFav(newsList :List<News> ) {
        this.dataNewsFavorite = newsList
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNewsFavorite.ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_news_favorite, parent, false)
        return AdapterNewsFavorite.ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterNewsFavorite.ViewHolder, position: Int) {
        holder.itemView.title.text = dataNewsFavorite!![position].title
        holder.itemView.createDate.text = dataNewsFavorite!![position].createdAt
        holder.itemView.author.text = dataNewsFavorite!![position].author
        Glide.with(holder.itemView.context).load(dataNewsFavorite!![position].image).into(holder.itemView.imageView)

        holder.itemView.cardNewsFav.setOnClickListener {
            onClick(dataNewsFavorite!![position])
        }

    }

    override fun getItemCount(): Int {
        return when (dataNewsFavorite) {
            null -> {
                0
            }
            else -> {
                dataNewsFavorite!!.size
            }
        }
    }

}