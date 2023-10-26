package com.example.galantapp.screens

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.galantapp.ImageAdapter
import com.example.galantapp.MAIN
import com.example.galantapp.MainActivity
import com.example.galantapp.R
import com.example.galantapp.galant.ImageDataClass

class GalleryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val images = listOf<ImageDataClass>(
            ImageDataClass("car1", R.drawable.car1)
        )
        val recyclerView = view?.findViewById<RecyclerView>(R.id.imagesRecyclerView)

        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        recyclerView?.setHasFixedSize(true)

        if (recyclerView != null) {
            recyclerView.adapter = ImageAdapter(this, images)
        }
        return inflater.inflate(R.layout.fragment_gallery, container, false)

    }

}