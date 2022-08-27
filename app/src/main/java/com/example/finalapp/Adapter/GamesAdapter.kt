package com.example.finalapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.R
import com.example.finalapp.model.Games

class GamesAdapter(
    private val dataSet : List<Games>
): RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    class GamesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.tourtxt)
        val imageView:ImageView=view.findViewById(R.id.tourImage)
    }//end GamerViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : GamesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.tournament_item,parent,false)
        return GamesViewHolder(adapterLayout)
    }// end onCreateViewHolder

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item.stringResourceId.toString()
        holder.imageView.setImageResource(item.imageResourceId)

    }//End onBindViewHolder

    override fun getItemCount(): Int {
        return dataSet.size
    }
}// End class GamerAdapter