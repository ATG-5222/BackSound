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
            if (mediaPlayer1!!.isPlaying){
                mediaPlayer1?.pause()
                mediaPlayer1?.seekTo(0)
            }
            else{
                mediaPlayer1?.start()
            }
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
            if (mediaPlayer2!!.isPlaying){
                mediaPlayer2?.pause()
                mediaPlayer2?.seekTo(0)
            }
            else{
                mediaPlayer2?.start()
            }
        }
    }

    private fun setCard3(){
        //Declarar MediaPlayer
        var mediaPlayer3: MediaPlayer? = MediaPlayer.create(this, R.raw.thexfiles)
        //Declaración de elementos
        val sound3CV : CardView = findViewById(R.id.sound3)
        //Ajustar background
        sound3CV.setBackgroundResource(R.drawable.thexfiles)
        //Reproducción de sonido cuando se presiona CV
        //Reproducción de sonido cuando se presiona CV
        sound3CV.setOnClickListener{
            if (mediaPlayer3!!.isPlaying){
                mediaPlayer3?.pause()
                mediaPlayer3?.seekTo(0)
            }
            else{
                mediaPlayer3?.start()
            }
        }
    }

    private fun setCard4(){
        //Declarar MediaPlayer
        var mediaPlayer4: MediaPlayer? = MediaPlayer.create(this, R.raw.jarabetapatio)
        //Declaración de elementos
        val sound4CV : CardView = findViewById(R.id.sound4)
        //Ajustar background
        sound4CV.setBackgroundResource(R.drawable.bandera)
        //Reproducción de sonido cuando se presiona CV
        sound4CV.setOnClickListener{
            if (mediaPlayer4!!.isPlaying){
                mediaPlayer4?.pause()
                mediaPlayer4?.seekTo(0)
            }
            else{
                mediaPlayer4?.start()
            }
        }
    }

    /////////////
}