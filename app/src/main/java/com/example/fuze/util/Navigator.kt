package com.example.fuze.util

import android.content.Context
import com.example.fuze.presentation.ui.MatchDetailActivity
import javax.inject.Inject

class Navigator @Inject constructor() : Navigation {
    override fun openDetailsActivity(context: Context, toolbarTitle: String, teamOne: Int, teamTwo: Int) {
        val activateIntent = MatchDetailActivity.newIntent(context = context)
        activateIntent.putExtra("toolbarTitle", toolbarTitle)
        activateIntent.putExtra("teamOne", teamOne)
        activateIntent.putExtra("teamTwo", teamTwo)
        context.startActivity(activateIntent)
    }
}

interface Navigation {
    fun openDetailsActivity(context: Context, toolbarTitle: String, teamOne: Int, teamTwo: Int)
}