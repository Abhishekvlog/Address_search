package com.example.addresssearch.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.addresssearch.R
import kotlinx.android.synthetic.main.activity_main.*
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.FloatingSearchView.OnQueryChangeListener
import com.example.addresssearch.ViewModel.MainViewModel
import com.example.addresssearch.ViewModel.MainViewModelFactory


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)


        floating_search_view.setOnQueryChangeListener(OnQueryChangeListener { oldQuery, newQuery -> //get suggestions based on newQuery

            //pass them on to the search view
            viewModel.getApi(newQuery).observe(this, Observer {
                floating_search_view.swapSuggestions(it.data!!.addressList)
            })

        })
    }

}