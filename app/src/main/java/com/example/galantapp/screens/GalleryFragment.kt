package com.example.galantapp.screens

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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
    ): View {
        // Inflate the layout for this fragment



        //val recyclerView = inflater.inflate(R.layout.fragment_gallery, container, false).findViewById<RecyclerView>(R.id.imagesRecyclerView)



        return inflater.inflate(R.layout.fragment_gallery, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val images = listOf<ImageDataClass>(
            ImageDataClass("Галант 8", R.drawable.car1),
            ImageDataClass("Галант 8", R.drawable.car2),
            ImageDataClass("Галант 8", R.drawable.car3),
            ImageDataClass("Галант 8", R.drawable.car4),
            ImageDataClass("Галант 8", R.drawable.car5),
            ImageDataClass("Галант 8", R.drawable.car6),
            ImageDataClass("Галант 8", R.drawable.galant_main_menu),
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(requireContext(), images )

        super.onViewCreated(view, savedInstanceState)
    }

}