package com.example.a24012011120_mad_practical7

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    companion object {
        const val SERVICE_KEY = "Service1"
        const val SERVICE_DATA = "PlayPause"
    }

    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        // Create MediaPlayer only once
        if (!::mediaPlayer.isInitialized) {
            mediaPlayer = MediaPlayer.create(this, R.raw.song)
        }

        if (intent != null) {
            val str1 = intent.getStringExtra(SERVICE_KEY)

            if (str1 == SERVICE_DATA) {

                if (!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {

        if (::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }

        super.onDestroy()
    }
}