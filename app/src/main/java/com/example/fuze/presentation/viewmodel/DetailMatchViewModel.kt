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

    var team: MutableLiveData<TeamResponse>? = MutableLiveData()

    fun getTeamData(id: Int){
        viewModelScope.launch {
            team?.value = teamRepository.getTeam(id)
        }
    }

}