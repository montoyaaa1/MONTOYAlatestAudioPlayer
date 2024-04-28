package com.example.playaudio

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var btnPlay : Button
    private lateinit var btnPause : Button
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)


        btnPlay.setOnClickListener{
             playAudio()
        }

        btnPause.setOnClickListener{
            pauseAudio()
        }
    }

    private fun playAudio() {
        val audioUrl = "https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {

            mediaPlayer!!.setDataSource(audioUrl)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()

        }catch (e: IOException){
            e.printStackTrace()
        }

        Toast.makeText(this, "Audio started playing", Toast.LENGTH_SHORT).show()
    }

    private fun pauseAudio() {
            if (mediaPlayer!!.isPlaying){

                 mediaPlayer!!.stop()
                mediaPlayer!!.reset()
                mediaPlayer!!.release()
            }else{
                Toast.makeText(this, "Audio has not played", Toast.LENGTH_SHORT).show()
            }
    }
}