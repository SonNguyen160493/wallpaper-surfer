package com.wallpaper.wallpapersurfer.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wallpaper.wallpapersurfer.R


class MasonryAdapter(private val context: Context) : RecyclerView.Adapter<MasonryAdapter.MasonryView>() {

    private var imgList = intArrayOf(
        R.drawable.two,
        R.drawable.one,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasonryView {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return MasonryView(layoutView)
    }

    override fun onBindViewHolder(holder: MasonryView, position: Int) {
        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions().placeholder(imgList[position]))
            .load(imgList[position])
            .into(holder.imageView)
//        holder.imageView.setImageResource(imgList[position])
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class MasonryView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById<View>(R.id.img) as ImageView
    }
}