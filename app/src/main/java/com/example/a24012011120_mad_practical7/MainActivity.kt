package com.example.a24012011120_mad_practical7

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Play / Pause Button
        findViewById<FloatingActionButton>(R.id.btnPlay).setOnClickListener {

            Intent(applicationContext, MusicService::class.java)
                .putExtra(MusicService.SERVICE_KEY, MusicService.SERVICE_DATA)
                .also { startService(it) }
        }

        // Stop Button
        findViewById<FloatingActionButton>(R.id.btnStop).setOnClickListener {

            Intent(applicationContext, MusicService::class.java)
                .also { stopService(it) }
        }


    }
}