package com.example.fuze.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.fuze.network.api.MatchesApi
import com.example.fuze.network.paging.MatchesRemoteMediator
import com.example.fuze.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val matchesApi: MatchesApi
) : ViewModel() {


    val newsList = Pager(PagingConfig(Constants.ITEMS_PER_PAGE)) {
        MatchesRemoteMediator(matchesApi)
    }.flow.cachedIn(viewModelScope)


}