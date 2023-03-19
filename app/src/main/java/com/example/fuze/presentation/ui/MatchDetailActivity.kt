package com.example.fuze.presentation.ui

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.fuze.databinding.ActivityMatchDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MatchDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbarTitle = intent.getStringExtra("toolbarTitle")
        val teamOne = intent.getStringExtra("teamOne")
        val teamTwo = intent.getStringExtra("teamTwo")
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarTitle?.let {
            supportActionBar!!.title = it
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