package com.dea.findthelyrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSongs: RecyclerView
    private var listSong: ArrayList<Song> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSongs = findViewById(R.id.rv_songs)
        rvSongs.setHasFixedSize(true)

        listSong.addAll(SongsData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setActivity(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setActivity(itemId: Int) {
        when(itemId){
            R.id.action_beranda -> {
                showRecyclerList()
            }
            R.id.action_profile -> {
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }
    }

    private fun showRecyclerList() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val listSongAdapter = ListSongAdapter(listSong)
        rvSongs.adapter = listSongAdapter

        listSongAdapter.setOnItemClickCallback(object: ListSongAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Song) {
                openSongsDetailActivity(data)
            }
        })
    }

    private fun openSongsDetailActivity(data: Song) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_TITLE, data.title)
        intent.putExtra(DetailActivity.EXTRA_SINGER, data.singer)
        intent.putExtra(DetailActivity.EXTRA_RELEASED_YEAR, data.releasedYear)
        intent.putExtra(DetailActivity.EXTRA_LYRICS, data.lyrics)
        intent.putExtra(DetailActivity.EXTRA_SONG_COVER, data.cover)
        startActivity(intent)
    }
}