package com.example.myselfappshasbi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    data class Item(val text: String, val imageResId: Int)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.findViewById(R.id.gambarDaily)
        val itemTextView: TextView = itemView.findViewById(R.id.kataDaily)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_daily, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImageView.setImageResource(item.imageResId)
        holder.itemTextView.text = item.text
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class CustomAdapterFriend(private val itemList: List<Item>) :
    RecyclerView.Adapter<CustomAdapterFriend.ViewHolder>() {

    data class Item(val text: String, val imageResId: Int)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.findViewById(R.id.gambarDaily)
        val itemTextView: TextView = itemView.findViewById(R.id.kataDaily)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_friend, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImageView.setImageResource(item.imageResId)
        holder.itemTextView.text = item.text
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class GridAdapter(private val context: Context, private val itemList: List<Int>) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId = itemList[position]
        holder.imageView.setImageResource(imageResId)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}

class CustomAdapterMusic(private val itemList: List<CustomAdapter.Item>) :
    RecyclerView.Adapter<CustomAdapterMusic.ViewHolder>() {

    data class Item(val text: String, val imageResId: Int)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.findViewById(R.id.gambarMusik)
        val itemTextView: TextView = itemView.findViewById(R.id.kataMusik)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_music, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImageView.setImageResource(item.imageResId)
        holder.itemTextView.text = item.text
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}