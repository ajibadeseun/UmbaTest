package com.umbatest.www

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

class MoviesAdapter(private val dataSet: List<LatestMoviesResult>,private val context: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private lateinit var  circularProgressDrawable: CircularProgressDrawable

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        public val movieTitle: TextView
        public val overview: TextView
        public val rating: TextView
        public val image: ImageView
        public val card:CardView

        init {
            // Define click listener for the ViewHolder's View.
            movieTitle = view.findViewById(R.id.movie_title)
            overview = view.findViewById(R.id.overview)
            rating = view.findViewById(R.id.rating)
            image = view.findViewById(R.id.image)
            card = view.findViewById(R.id.card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list_item_layout, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Customizing the progress bar showing the flag
        circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 15f
        circularProgressDrawable.start()

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val data = dataSet[position]

        holder.overview.text = data.overview
        holder.movieTitle.text = data.title
        holder.rating.text = data.voteAverage.toString()
        val imgUrl = "http://image.tmdb.org/t/p/original".plus(data.backdropPath)
        imgUrl.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            holder.image.load(imgUri) {
                placeholder(circularProgressDrawable)
                error(R.drawable.ic_error_img)
            }
        }
        holder.card.setOnClickListener {
            val intent = Intent(context,MovieDetailsActivity::class.java)
            intent.putExtra("data",data)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = dataSet.size

}