package com.example.fuze.presentation.ui

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
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

    @SuppressLint("SetTextI18n")
    private fun getTeamsDetails() {
        lifecycleScope.launch {
            viewModel.teamOne?.observe(this@MatchDetailActivity, Observer { teamOne ->
                binding.apply {
                    prgBar.isVisible = false
                    teamsPlayers.isVisible = true
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
                    if(teamOne.players.isNotEmpty()){
                        one.nickname.text = teamOne.players[0].nickName
                        two.nickname.text = teamOne.players[1].nickName
                        three.nickname.text = teamOne.players[2].nickName
                        four.nickname.text = teamOne.players[3].nickName
                        five.nickname.text = teamOne.players[4].nickName

                        one.name.text = "${teamOne.players[0].first_name} ${teamOne.players[0].last_name}"
                        two.name.text = "${teamOne.players[1].first_name} ${teamOne.players[1].last_name}"
                        three.name.text = "${teamOne.players[2].first_name} ${teamOne.players[2].last_name}"
                        four.name.text = "${teamOne.players[3].first_name} ${teamOne.players[3].last_name}"
                        five.name.text = "${teamOne.players[4].first_name} ${teamOne.players[4].last_name}"

                        teamOne.players[0].image_url?.let {
                            one.imagePlayer.load(
                                it
                            )
                        } ?: run {
                            one.imagePlayer.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamOne.players[1].image_url?.let {
                            two.imagePlayer.load(
                                it
                            )
                        } ?: run {
                            two.imagePlayer.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamOne.players[2].image_url?.let {
                            three.imagePlayer.load(
                                it
                            )
                        } ?: run {
                            three.imagePlayer.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamOne.players[3].image_url?.let {
                            four.imagePlayer.load(
                                it
                            )
                        } ?: run {
                            four.imagePlayer.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamOne.players[4].image_url?.let {
                            five.imagePlayer.load(
                                it
                            )
                        } ?: run {
                            five.imagePlayer.load(com.example.fuze.R.drawable.rectangle_image)
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

                    if(teamTwo.players.isNotEmpty()){
                        one.nicknameR.text = teamTwo.players[0].nickName
                        two.nicknameR.text = teamTwo.players[1].nickName
                        three.nicknameR.text = teamTwo.players[2].nickName
                        four.nicknameR.text = teamTwo.players[3].nickName
                        five.nicknameR.text = teamTwo.players[4].nickName

                        one.nameR.text = "${teamTwo.players[0].first_name} ${teamTwo.players[0].last_name}"
                        two.nameR.text = "${teamTwo.players[1].first_name} ${teamTwo.players[1].last_name}"
                        three.nameR.text = "${teamTwo.players[2].first_name} ${teamTwo.players[2].last_name}"
                        four.nameR.text = "${teamTwo.players[3].first_name} ${teamTwo.players[3].last_name}"
                        five.nameR.text = "${teamTwo.players[4].first_name} ${teamTwo.players[4].last_name}"

                        teamTwo.players[0].image_url?.let {
                            one.imagePlayerR.load(
                                it
                            )
                        } ?: run {
                            one.imagePlayerR.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamTwo.players[1].image_url?.let {
                            two.imagePlayerR.load(
                                it
                            )
                        } ?: run {
                            two.imagePlayerR.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamTwo.players[2].image_url?.let {
                            three.imagePlayerR.load(
                                it
                            )
                        } ?: run {
                            three.imagePlayerR.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamTwo.players[3].image_url?.let {
                            four.imagePlayerR.load(
                                it
                            )
                        } ?: run {
                            four.imagePlayerR.load(com.example.fuze.R.drawable.rectangle_image)
                        }

                        teamTwo.players[4].image_url?.let {
                            five.imagePlayerR.load(
                                it
                            )
                        } ?: run {
                            five.imagePlayerR.load(com.example.fuze.R.drawable.rectangle_image)
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