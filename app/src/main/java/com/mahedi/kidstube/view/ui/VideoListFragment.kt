package com.mahedi.kidstube.view.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahedi.kidstube.R
import com.mahedi.kidstube.view.adapter.VideoAdapter
import com.mahedi.kidstube.viewmodel.VideoListViewModel
import kotlinx.android.synthetic.main.video_item.view.*


class VideoListFragment : Fragment() {


    private lateinit var rootView: View

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var progressBar: ProgressBar


    lateinit var videoListViewModel: VideoListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.video_list_fragment, container, false);
        initializeRecyclerView()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoListViewModel = VideoListViewModel()
        videoListViewModel.getSearchData("songs")

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
        videoListViewModel.searchSuccessLiveData.observe(viewLifecycleOwner, Observer { searchResult ->
            Log.e(TAG, "RESULT -> $searchResult")
            progressBar.visibility = View.INVISIBLE
            searchResult.items?.let { videoAdapter.addVideos(it) }
        })
    }

    private fun initializeRecyclerView() {
        progressBar = rootView.findViewById(R.id.progressBar)
        recyclerView = rootView.findViewById(R.id.videoListRV)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        videoAdapter = VideoAdapter()
        recyclerView.adapter = videoAdapter

//        var data = mutableListOf("one", "two", "three", "four")
//        videoAdapter.addVideos()
    }
}
