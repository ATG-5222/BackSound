package com.example.backsound

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setCard1()
        setCard2()
    }
    //////////////

    private fun setCard1(){
        //Declarar MediaPlayer
        var mediaPlayer1: MediaPlayer? = MediaPlayer.create(this, R.raw.necoarc)
        //Declaración de elementos
        val sound1CV : CardView = findViewById(R.id.sound1)
        //Ajustar background
        sound1CV.setBackgroundResource(R.drawable.necoarc)
        //Reproducción de sonido cuando se presiona CV
        sound1CV.setOnClickListener{
            mediaPlayer1?.start()
        }
    }

    private fun setCard2(){
        //Declarar MediaPlayer
        var mp = MediaPlayer()
        //Declaración de elementos
        val sound2CV : CardView = findViewById(R.id.sound2)
        //Ajustar background
        sound2CV.setBackgroundResource(R.drawable.desaparecer)
    }

    /////////////
}