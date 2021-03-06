package com.dea.findthelyrics

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_SINGER = "extra_singer"
        const val EXTRA_RELEASED_YEAR = "extra_release_year"
        const val EXTRA_LYRICS = "extra_lyrics"
        const val EXTRA_SONG_COVER = "extra_song_cover"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        supportActionBar?.setBackgroundDrawable(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvTitle: TextView = findViewById(R.id.tv_judul_lagu)
        val tvSinger: TextView? = findViewById(R.id.tv_penyanyi)
        val tvReleasedYear: TextView? = findViewById(R.id.tv_tahun)
        val tvLyrics: TextView? = findViewById(R.id.tv_lirik)
        val ivCover: ImageView = findViewById(R.id.img_cover)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val singer = intent.getStringExtra(EXTRA_SINGER)
        val releasedYear = intent.getStringExtra(EXTRA_RELEASED_YEAR)
        val lyrics = intent.getStringExtra(EXTRA_LYRICS)
        val imgCover = intent.getIntExtra(EXTRA_SONG_COVER, R.color.army_light)

        supportActionBar?.title = title
        tvTitle.text = title
        tvSinger?.text = singer
        tvReleasedYear?.text = releasedYear
        tvLyrics?.text = lyrics

        Glide.with(this)
            .load(imgCover)
            .apply(RequestOptions().fitCenter())
            .into(ivCover)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}