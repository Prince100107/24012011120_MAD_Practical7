package com.example.a24012011120_mad_practical7

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MusicService : Service() {

    companion object {
        const val SERVICE_KEY = "Service1"
        const val SERVICE_DATA = "PlayPause"
        private const val TAG = "MusicService"
    }

    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand called")

        if (intent != null) {
            val str1 = intent.getStringExtra(SERVICE_KEY)

            if (str1 == SERVICE_DATA) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.song)
                    mediaPlayer?.isLooping = true
                }

                mediaPlayer?.let { player ->
                    if (!player.isPlaying) {
                        player.start()
                        Toast.makeText(this, "Playing Music 🎵", Toast.LENGTH_SHORT).show()
                    } else {
                        player.pause()
                        Toast.makeText(this, "Music Paused ⏸️", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy called")
        mediaPlayer?.let { player ->
            if (player.isPlaying) {
                player.stop()
            }
            player.release()
        }
        mediaPlayer = null
        Toast.makeText(this, "Music Stopped ⏹️", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}