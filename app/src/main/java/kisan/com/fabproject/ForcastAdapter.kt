package kisan.com.fabproject


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.forcast_list.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by hp on 07-12-2018.
 */

class ForcastAdapter(internal var list: List<ForcastModel>) : RecyclerView.Adapter<ForcastAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forcast_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.date.text = getDate(list[position].date)
        holder.itemView.temp.text = list[position].maxT.toFloat().toInt().toString() + " C"

    }

    private fun getDate(dat: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(dat)
       return  SimpleDateFormat("EEEE").format(date)
    }


    override fun getItemCount(): Int {
        return list.size
    }

     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
