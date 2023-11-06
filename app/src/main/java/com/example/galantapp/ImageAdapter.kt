package com.example.galantapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galantapp.databinding.ItemImagesBinding
import com.example.galantapp.galant.Image


class ImageAdapter(
    private val images: List<Image>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(
        private val binding: ItemImagesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(image: Image) {
            with(binding) {
                ivCarImage.setImageResource(image.imageSrc)
                tvImageTitle.text = image.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        ItemImagesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}