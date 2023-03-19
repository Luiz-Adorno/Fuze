package com.example.fuze.presentation.ui

import android.R
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

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
       // supportActionBar.setTitle()
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
}