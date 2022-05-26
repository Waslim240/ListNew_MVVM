package waslim.binar.andlima.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_listing_film.view.*
import waslim.binar.andlima.mvvm.R
import waslim.binar.andlima.mvvm.model.GetAllFilmResponseItem

class AdapterFilm(private var onclick : (GetAllFilmResponseItem) -> Unit) : RecyclerView.Adapter<AdapterFilm.ViewHolder> () {

    private var datafilm : List<GetAllFilmResponseItem>? = null

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm.ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_listing_film, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AdapterFilm.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(datafilm!![position].image).into(holder.itemView.imageFilm)
        holder.itemView.tvJudul.text = datafilm!![position].name
        holder.itemView.tvTglRilis.text = datafilm!![position].date
        holder.itemView.tvSutradara.text = datafilm!![position].director

        holder.itemView.cardDetailFilm.setOnClickListener {
            onclick(datafilm!![position])
        }
    }

    override fun getItemCount(): Int {
        return when (datafilm) {
            null -> {
                0
            }
            else -> {
                datafilm!!.size
            }
        }
    }

    fun setDataFilm(film : List<GetAllFilmResponseItem>){
        this.datafilm = film
    }

}