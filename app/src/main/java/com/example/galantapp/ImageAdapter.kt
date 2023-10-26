package com.example.galantapp

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.galantapp.galant.ImageDataClass


class ImageAdapter(
    private val context: Context,
    private val images: List<ImageDataClass>
    ): RecyclerView.Adapter<ImageAdapter.ImageViewHolder> (){

    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img = itemView.findViewById<ImageView>(R.id.image)
        var imgTitle = itemView.findViewById<TextView>(R.id.image_title)

        fun bindView (image: ImageDataClass){
            img.setImageResource(image.imageSrc)
            imgTitle.text = image.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_images, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }
}