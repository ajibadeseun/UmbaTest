package com.umbatest.www

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView


class LatestMoviesFragment : Fragment() {
    private val viewModel:TmdbViewModel by viewModels()
    private lateinit var  latestMoviesList: RecyclerView
    private lateinit var latestMoviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latestMoviesList = view.findViewById(R.id.latest_list)

        launchLatestMovies()
    }

    private fun launchLatestMovies(pageNum:Int = 1){
        viewModel.getLatestMovies(pageNum).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        //resource.data?.let { users -> retrieveList(users) }
                        //Toast.makeText(requireActivity(),"Success", Toast.LENGTH_LONG).show()
                        latestMoviesAdapter =
                            resource.data?.let { it -> MoviesAdapter(it.results,requireActivity()) }!!
                        latestMoviesList.adapter = latestMoviesAdapter
                    }
                    Status.ERROR -> {

                        Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(requireActivity(),"Loading", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }

}