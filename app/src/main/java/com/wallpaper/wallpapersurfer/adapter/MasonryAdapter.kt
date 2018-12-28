package com.wallpaper.wallpapersurfer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wallpaper.wallpapersurfer.R
import com.wallpaper.wallpapersurfer.model.PhotoResponse


class MasonryAdapter(private val context: Context, private val photos: ArrayList<PhotoResponse>) : RecyclerView.Adapter<MasonryAdapter.MasonryView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasonryView {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return MasonryView(layoutView)
    }

    override fun onBindViewHolder(holder: MasonryView, position: Int) {
        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.default_image))
            .load(photos[position].urls.small)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class MasonryView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById<View>(R.id.img) as ImageView
    }
}

//    private var imgList = intArrayOf(
//        R.drawable.two,
//        R.drawable.one,
//        R.drawable.three,
//        R.drawable.four,
//        R.drawable.five,
//        R.drawable.six,
//        R.drawable.seven,
//        R.drawable.eight,
//        R.drawable.nine,
//        R.drawable.ten
//    )