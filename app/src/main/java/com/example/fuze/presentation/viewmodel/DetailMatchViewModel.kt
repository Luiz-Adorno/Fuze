package com.example.fuze.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fuze.network.model.TeamResponse
import com.example.fuze.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMatchViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    var teamOne: MutableLiveData<TeamResponse>? = MutableLiveData()
    var teamTwo: MutableLiveData<TeamResponse>? = MutableLiveData()

    fun getTeamOneData(id: Int){
        viewModelScope.launch {
            teamOne?.value = teamRepository.getTeam(id)
        }
    }
    fun getTeamTwoData(id: Int){
        viewModelScope.launch {
            teamTwo?.value = teamRepository.getTeam(id)
        }
    }

}