package com.mahedi.kidstube.service.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Mahedi Hassan
 * 2020-05-18
 */

const val YOUTUBE_API_BASE_URL = "https://www.googleapis.com/youtube/v3/";

object RetrofitClient {
    val youTubeAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(YOUTUBE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(YouTubeAPIService::class.java)
    }
}