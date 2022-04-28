package waslim.binar.andlima.json.adapter.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_adapter_film.view.*
import waslim.binar.andlima.json.R
import waslim.binar.andlima.json.model.film.GetAllFilmResponseItem

class AdapterFilm : RecyclerView.Adapter<AdapterFilm.ViewHolder> () {

    private var datafilm : List<GetAllFilmResponseItem>? = null

    fun setDataFilm(film : List<GetAllFilmResponseItem>){
        this.datafilm = film
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter_film, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.name.text = datafilm!![position].name
        holder.itemView.date.text = datafilm!![position].date
        holder.itemView.director.text = datafilm!![position].director
        Glide.with(holder.itemView.context).load(datafilm!![position].image).into(holder.itemView.image_film)

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


}
