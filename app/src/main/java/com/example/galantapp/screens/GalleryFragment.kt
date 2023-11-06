package com.example.galantapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galantapp.ImageAdapter
import com.example.galantapp.R
import com.example.galantapp.databinding.FragmentGalleryBinding
import com.example.galantapp.galant.Image

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private val images = listOf(
        Image("Галант 8", R.drawable.car1),
        Image("Акула", R.drawable.car2),
        Image("Galant VIII", R.drawable.car3),
        Image("Shark", R.drawable.car4),
        Image("Галант 8", R.drawable.car5),
        Image("Галант 8", R.drawable.car6),
        Image("Галант 8", R.drawable.galant_main_menu),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        initRV()
    }

    private fun initRV() {
        with(binding.imagesRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = ImageAdapter(
                images = images
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}