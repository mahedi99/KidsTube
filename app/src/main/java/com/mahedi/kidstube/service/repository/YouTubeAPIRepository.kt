package com.mahedi.kidstube.service.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mahedi.kidstube.service.model.youtube_search.YoutubeSearchModel
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author Mahedi Hassan
 * 2020-05-18
 */

class YouTubeAPIRepository {

    val searchLiveData = MutableLiveData<YoutubeSearchModel>()
    val searchFailureLiveData = MutableLiveData<Boolean>()

    var client: YouTubeAPIService = RetrofitClient.youTubeAPIService

    suspend fun getSearchData(q: String) {
        try {

            //here api calling became so simple just 1 line of code
            //there is no callback needed

            val response = client.searchQuery(q)

            Log.d(TAG, "$response")

            if (response.isSuccessful) {
//                Log.d(TAG, "SUCCESS")
//                Log.d(TAG, "${response.body()}")
                searchLiveData.postValue(response.body())

            } else {
//                Log.d(TAG, "FAILURE")
//                Log.d(TAG, "${response.body()}")
                searchFailureLiveData.postValue(true)
            }

        } catch (e: UnknownHostException) {
            Log.e(TAG, e.message)
            //this exception occurs when there is no internet connection or host is not available
            //so inform user that something went wrong
            searchFailureLiveData.postValue(true)
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message)
            //this exception occurs when time out will happen
            //so inform user that something went wrong
            searchFailureLiveData.postValue(true)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            //this is generic exception handling
            //so inform user that something went wrong
            searchFailureLiveData.postValue(true)
        }
    }

    companion object {
        val TAG: String = YouTubeAPIRepository::class.java.simpleName
    }
}