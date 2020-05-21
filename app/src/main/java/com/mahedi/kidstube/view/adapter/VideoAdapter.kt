package com.mahedi.kidstube.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.mahedi.kidstube.R
import com.mahedi.kidstube.service.model.youtube_search.ItemsItem
import com.mahedi.kidstube.util.loadImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_item.view.*


class VideoAdapter() : RecyclerView.Adapter<VideoAdapter.DataViewHolder>() {

    private val videos = mutableListOf<ItemsItem>()

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        private val videoTitleTV: TextView = itemView.findViewById(R.id.videoTitleTV)

        fun bind(video: ItemsItem?) {
            itemView.apply {
                videoTitleTV.text = video?.snippet?.title
                imageViewAvatar.loadImage(video?.snippet?.thumbnails?.high?.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false))

    override fun getItemCount(): Int = videos?.size!!

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(videos?.get(position))
    }

    fun addVideos(videos: MutableList<ItemsItem>) {
        this.videos?.apply {
            clear()
            addAll(videos)
        }
        notifyDataSetChanged()
    }
}