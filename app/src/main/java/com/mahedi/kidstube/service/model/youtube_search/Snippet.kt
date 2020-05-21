package com.mahedi.kidstube.service.model.youtube_search

import com.mahedi.kidstube.service.model.youtube_search.Thumbnails

data class Snippet(val publishTime: String = "",
                   val publishedAt: String = "",
                   val description: String = "",
                   val title: String = "",
                   val thumbnails: Thumbnails,
                   val channelId: String = "",
                   val channelTitle: String = "",
                   val liveBroadcastContent: String = "")