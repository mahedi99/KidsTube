package com.mahedi.kidstube.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahedi.kidstube.service.repository.YouTubeAPIRepository
import kotlinx.coroutines.launch

/**
 * @author Mahedi Hassan
 * 2020-05-18
 */

class VideoListViewModel: ViewModel() {
    val repository: YouTubeAPIRepository = YouTubeAPIRepository()

    val searchSuccessLiveData = repository.searchLiveData
    val searchFailureLiveData = repository.searchFailureLiveData

    fun getSearchData(q: String) {
        //this is coroutine viewmodel scope to call suspend fun of repo
        viewModelScope.launch { repository.getSearchData(q) }
    }
}