package com.example.fuze.presentation.ui

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.fuze.databinding.ActivityMatchDetailBinding
import com.example.fuze.presentation.viewmodel.DetailMatchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MatchDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchDetailBinding
    private val viewModel: DetailMatchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarTitle = intent.getStringExtra("toolbarTitle")
        val teamOne = intent.getIntExtra("teamOne", 0)
        val teamTwo = intent.getIntExtra("teamTwo", 0)
        viewModel.getTeamOneData(teamOne)
        viewModel.getTeamTwoData(teamTwo)
        getTeamsDetails()

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.let {
            supportActionBar!!.title = it
        }
    }

    private fun getTeamsDetails() {
        lifecycleScope.launch {
            viewModel.teamOne?.observe(this@MatchDetailActivity, Observer { teamOne ->
                binding.apply {
                    firstOpponentName.text = teamOne.name
                    teamOne.image_url?.let { url ->
                        firstOpponent.load(url){
                            placeholder(com.example.fuze.R.drawable.team_logo)
                        }
                    } ?: run {
                        firstOpponent.load(com.example.fuze.R.drawable.team_logo){
                            placeholder(com.example.fuze.R.drawable.team_logo)
                        }
                    }
                }
            })
            viewModel.teamTwo?.observe(this@MatchDetailActivity, Observer { teamTwo ->
                binding.apply {
                    secondOpponentName.text = teamTwo.name
                    teamTwo.image_url?.let { url ->
                        secondOpponent.load(url){
                            placeholder(com.example.fuze.R.drawable.team_logo)
                        }
                    } ?: run {
                        secondOpponent.load(com.example.fuze.R.drawable.team_logo){
                            placeholder(com.example.fuze.R.drawable.team_logo)
                        }
                    }
                }
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
        }
        return false
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MatchDetailActivity::class.java)
    }
}