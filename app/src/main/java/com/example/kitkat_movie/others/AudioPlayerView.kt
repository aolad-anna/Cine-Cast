package com.example.kitkat_movie.others

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kitkat_movie.R
import com.example.kitkat_movie.databinding.ActivityAudioPlayerViewBinding
import com.example.kitkat_movie.databinding.ActivityPlayerViewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout

class AudioPlayerView : AppCompatActivity() {
    private var player: SimpleExoPlayer? = null
    private val TAG = "PlayerActivity"
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private var playUrl : String? = null
    private val playbackStateListener: Player.EventListener = playbackStateListener()

    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityAudioPlayerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_player_view)
        setContentView(viewBinding.root)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        );

        val intent1: Intent = intent

        var dataplayUrl = intent1.getStringExtra("playUrl")
        var datamovie_name = intent1.getStringExtra("movie_name")
        var datarelease_year = intent1.getStringExtra("release_year")
        var datamovie_img = intent1.getStringExtra("movie_img")
        // Log.d("_show", data+"aaaaa")
        playUrl = dataplayUrl

        val TotalAffect: TextView = findViewById(R.id.title)
        TotalAffect.text = datamovie_name

        val TotalAffect1: TextView = findViewById(R.id.textView12)
        TotalAffect1.text = datarelease_year


        val requestOptions = RequestOptions()
            .placeholder(R.drawable.blueprint)
            .error(R.drawable.blueprint)

        val TotalAffect1110: ImageView = findViewById(R.id.imageView11)
        Glide.with(this).applyDefaultRequestOptions(requestOptions).load(datamovie_img)
            .into(TotalAffect1110)

        val coiButton: ImageButton = findViewById<View>(R.id.imageButton) as ImageButton
        coiButton.setOnClickListener {
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
        val trackSelector = DefaultTrackSelector(this).apply {
            setParameters(buildUponParameters().setMaxVideoSizeSd())
        }
        player = SimpleExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .build()
            .also { exoPlayer ->
                viewBinding.videoView.player = exoPlayer
                viewBinding.videoView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
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
                    "ExoPlayer.STATE_IDLE-"}
                ExoPlayer.STATE_BUFFERING -> {
                    "ExoPlayer.STATE_BUFFERING -"}
                ExoPlayer.STATE_READY -> {
                    "ExoPlayer.STATE_READY-"}
                ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED-"
                else -> {
                    "UNKNOWN_STATE-"}
            }
            Log.d(TAG, "changed state to $stateString")
        }
    }


}