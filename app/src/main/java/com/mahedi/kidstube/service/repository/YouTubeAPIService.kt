package com.mahedi.kidstube.service.repository

import android.app.Activity
import com.mahedi.kidstube.service.model.youtube_search.YoutubeSearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * @author Mahedi Hassan
 * 2020-05-18
 */

const val KEY = "AIzaSyBvCzkCSX1GZq3a125Y9np5lMKZ4aN37DA"

interface YouTubeAPIService {

    @Headers("Content-Type: application/json")
    @GET("search?key=${KEY}&part=snippet&maxResults=50")
    suspend fun searchQuery(@Query("q") q: String): Response<YoutubeSearchModel>
}