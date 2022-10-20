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
        setCard3()
        setCard4()
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
        var mediaPlayer2: MediaPlayer? = MediaPlayer.create(this, R.raw.desaparecer)
        //Declaración de elementos
        val sound2CV : CardView = findViewById(R.id.sound2)
        //Ajustar background
        sound2CV.setBackgroundResource(R.drawable.desaparecer)
        //Reproducción de sonido cuando se presiona CV
        sound2CV.setOnClickListener{
            mediaPlayer2?.start()
        }
    }

    private fun setCard3(){
        //Declarar MediaPlayer
        var mediaPlayer3: MediaPlayer? = MediaPlayer.create(this, R.raw.thexfiles)
        //Declaración de elementos
        val sound2CV : CardView = findViewById(R.id.sound3)
        //Ajustar background
        sound2CV.setBackgroundResource(R.drawable.thexfiles)
        //Reproducción de sonido cuando se presiona CV
        sound2CV.setOnClickListener{
            mediaPlayer3?.start()
        }
    }

    private fun setCard4(){
        //Declarar MediaPlayer
        var mediaPlayer4: MediaPlayer? = MediaPlayer.create(this, R.raw.jarabetapatio)
        //Declaración de elementos
        val sound2CV : CardView = findViewById(R.id.sound4)
        //Ajustar background
        sound2CV.setBackgroundResource(R.drawable.bandera)
        //Reproducción de sonido cuando se presiona CV
        sound2CV.setOnClickListener{
            mediaPlayer4?.start()
        }
    }

    /////////////
}