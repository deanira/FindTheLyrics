package com.dea.findthelyrics

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListSongAdapter(private val listSong: ArrayList<Song>) :
    RecyclerView.Adapter<ListSongAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_judul_lagu)
        var tvSinger: TextView = itemView.findViewById(R.id.tv_penyanyi)
        var tvReleasedYear: TextView = itemView.findViewById(R.id.tv_tahun)
        var imgCover: ImageView = itemView.findViewById(R.id.img_cover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_song, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val song: Song = listSong[position]

        Glide.with(holder.itemView.context)
            .load(song.cover)
            .apply(RequestOptions().override(100, 100))
            .into(holder.imgCover)

        holder.tvTitle.text = song.title
        holder.tvSinger.text = song.singer
        holder.tvReleasedYear.text = song.releasedYear

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(song) }
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Song)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}