package com.example.kitkat_movie.others

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.util.Util
import com.example.kitkat_movie.R
import com.example.kitkat_movie.databinding.ActivityPlayerViewBinding
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.cache.CacheDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util.SDK_INT
import com.google.common.collect.BiMap

class PlayerView : AppCompatActivity() {
    private var player: SimpleExoPlayer? = null
    private val TAG = "PlayerActivity"
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private var playUrl : String? = null
    private val playbackStateListener: Player.EventListener = playbackStateListener()

    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityPlayerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_view)
        setContentView(viewBinding.root)

        val intent1: Intent = intent

        var dataplayUrl = intent1.getStringExtra("playUrl")
        // Log.d("_show", data+"aaaaa")
        playUrl = dataplayUrl

        val coButton: ImageButton = findViewById<View>(R.id.button344) as ImageButton
        coButton.setOnClickListener {
            super.onBackPressed();
        }
    }
    public override fun onStart() {
        super.onStart()
        if (com.google.android.exoplayer2.util.Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 23 || player == null) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    public override fun onStop() {
        super.onStop()
        if (com.google.android.exoplayer2.util.Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

    private fun initializePlayer() {
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        val trackSelector = DefaultTrackSelector(this).apply {
            setParameters(buildUponParameters().setMaxVideoSizeSd())
        }
        player = SimpleExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .build()
            .also { exoPlayer ->
                viewBinding.videoView.player = exoPlayer
                viewBinding.videoView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                val mediaItem = MediaItem.Builder()
                    .setUri(playUrl)
//                    .setMimeType(MimeTypes.APPLICATION_MPD)
                    .build()
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.addListener(playbackStateListener)
                exoPlayer.prepare()
            }

    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            removeListener(playbackStateListener)
            release()
        }
        player = null
    }
    private fun playbackStateListener() = object : Player.EventListener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            val stateString: String = when (playbackState) {
                ExoPlayer.STATE_IDLE -> {
                    val progress = findViewById<View>(R.id.progress0000)
                    progress.visibility=View.GONE
                    val controll = findViewById<View>(R.id.frameLayout2)
                    controll.visibility=View.VISIBLE
                    "ExoPlayer.STATE_IDLE-"}
                ExoPlayer.STATE_BUFFERING -> {
                    val progress = findViewById<View>(R.id.progress0000)
                    progress.visibility=View.VISIBLE
                    val controll = findViewById<View>(R.id.frameLayout2)
                    controll.visibility=View.GONE
                    "ExoPlayer.STATE_BUFFERING -"}
                ExoPlayer.STATE_READY -> {
                    val controll = findViewById<View>(R.id.frameLayout2)
                    controll.visibility=View.VISIBLE
                    val progress = findViewById<View>(R.id.progress0000)
                    progress.visibility=View.GONE
                    "ExoPlayer.STATE_READY-"}
                ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED-"
                else -> {
                    val controll = findViewById<View>(R.id.frameLayout2)
                    controll.visibility=View.VISIBLE
                    val progress = findViewById<View>(R.id.progress0000)
                    progress.visibility=View.GONE
                    "UNKNOWN_STATE-"}
            }
            Log.d(TAG, "changed state to $stateString")
        }
    }


}