package com.umbatest.www

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var content : TextView
    private lateinit var voteCount: TextView
    private lateinit var title:TextView
    private lateinit var image: ImageView
    private lateinit var data: LatestMoviesResult
    private lateinit var circularProgressDrawable: CircularProgressDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 15f
        circularProgressDrawable.start()

        data = intent.getParcelableExtra("data")!!



        content = findViewById(R.id.content)
        voteCount = findViewById(R.id.no_of_vote_count)
        title = findViewById(R.id.title)
        image = findViewById(R.id.center_image)

        //setting the values to be displayed to the user
        title.text = data.title
        voteCount.text = data.voteAverage.toString()
        content.text = data.overview

        val imgUrl = "http://image.tmdb.org/t/p/original".plus(data.backdropPath)
        imgUrl.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            image.load(imgUri) {
                placeholder(circularProgressDrawable)
                error(R.drawable.ic_error_img)
            }
        }

    }
}