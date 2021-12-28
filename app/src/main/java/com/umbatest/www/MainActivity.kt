package com.umbatest.www

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject





class MainActivity : AppCompatActivity() {
    //private val viewModel: TmdbViewModel by viewModels()

    private lateinit var viewModel:TmdbViewModel
    private lateinit var bottomNavigationView: BottomNavigationView


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            )[TmdbViewModel::class.java]


        loadFragment(LatestMoviesFragment())
        bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.latest_item -> {
                    // Write your code here
                    loadFragment(LatestMoviesFragment())
                }
                R.id.popular_item-> {
                    // Write your code here
                    loadFragment(PopularMoviesFragment())
                }
                R.id.upcoming_item->{
                     loadFragment(UpcomingMoviesFragment())
                }
            }
            return@setOnItemSelectedListener true
        }


    }
    fun loadFragment(fragment: Fragment) = run {
        val fragmentTag: String = fragment.javaClass.name
        supportFragmentManager.beginTransaction().replace(R.id.main_container,fragment,fragmentTag).addToBackStack(fragmentTag).commit()
        return@run
    }

}