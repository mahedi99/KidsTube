package com.mahedi.kidstube.service.model.youtube_search

data class YoutubeSearchModel(val regionCode: String = "",
                              val kind: String = "",
                              val nextPageToken: String = "",
                              val pageInfo: PageInfo,
                              val etag: String = "",
                              val items: MutableList<ItemsItem>?)