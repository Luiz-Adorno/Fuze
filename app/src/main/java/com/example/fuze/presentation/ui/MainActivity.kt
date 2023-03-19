package com.example.fuze.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fuze.R
import com.example.fuze.databinding.ActivityMainBinding
import com.example.fuze.presentation.adapter.HomeAdapter
import com.example.fuze.presentation.adapter.LoadMoreAdapter
import com.example.fuze.presentation.viewmodel.HomeViewModel
import com.example.fuze.util.initRecycler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var homeAdapter: HomeAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {

            viewModel.newsList.collect{
                homeAdapter.submitData(it)
            }
        }

        homeAdapter.setOnItemClickListener {
            if(it.opponents.size == 2){

            } else {
                Toast.makeText(applicationContext, R.string.opponents_not_defined,Toast.LENGTH_SHORT).show()
            }
        }
        binding.apply {

            recyclerHomeMatches.apply {
                initRecycler(LinearLayoutManager(this@MainActivity), homeAdapter)
                /* if something goes wrong to download more content
                (ex: internet lost connection after paging initialization),
                will show retry button */
                adapter = homeAdapter.withLoadStateFooter(
                    LoadMoreAdapter {
                        homeAdapter.retry()
                    }
                )
            }

            //Shows progress bar while loading data
            lifecycleScope.launch {
                homeAdapter.loadStateFlow.collect {
                    val state = it.refresh
                    prgBar.isVisible = state is LoadState.Loading
                    val list = homeAdapter.snapshot()
                    //  Log.d("Main Activity","current list is $list")
                }
            }

        }
    }
}