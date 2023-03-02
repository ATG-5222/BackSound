package com.example.backsound

import android.media.MediaPlayer
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
        setCard5()
        setCard6()
        setCard7()
        setCard8()
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

    private fun setCard5(){
        //Declarar MediaPlayer
        var mediaPlayer5: MediaPlayer? = MediaPlayer.create(this, R.raw.kirbyconchetumadre)
        //Declaración de elementos
        val sound3CV : CardView = findViewById(R.id.sound5)
        //Ajustar background
        sound3CV.setBackgroundResource(R.drawable.kirby)
        //Reproducción de sonido cuando se presiona CV
        //Reproducción de sonido cuando se presiona CV
        sound3CV.setOnClickListener{
            if (mediaPlayer5!!.isPlaying){
                mediaPlayer5?.pause()
                mediaPlayer5?.seekTo(0)
            }
            else{
                mediaPlayer5?.start()
            }
        }
    }

    private fun setCard6(){
        //Declarar MediaPlayer
        var mediaPlayer6: MediaPlayer? = MediaPlayer.create(this, R.raw.ftsimout)
        //Declaración de elementos
        val sound4CV : CardView = findViewById(R.id.sound6)
        //Ajustar background
        sound4CV.setBackgroundResource(R.drawable.fts)
        //Reproducción de sonido cuando se presiona CV
        sound4CV.setOnClickListener{
            if (mediaPlayer6!!.isPlaying){
                mediaPlayer6?.pause()
                mediaPlayer6?.seekTo(0)
            }
            else{
                mediaPlayer6?.start()
            }
        }
    }

    private fun setCard7(){
        //Declarar MediaPlayer
        var mediaPlayer7: MediaPlayer? = MediaPlayer.create(this, R.raw.badumtss)
        //Declaración de elementos
        val sound7CV : CardView = findViewById(R.id.sound7)
        //Ajustar background
        sound7CV.setBackgroundResource(R.drawable.badumtss)
        //Reproducción de sonido cuando se presiona CV
        sound7CV.setOnClickListener{
            if (mediaPlayer7!!.isPlaying){
                mediaPlayer7?.pause()
                mediaPlayer7?.seekTo(0)
            }
            else{
                mediaPlayer7?.start()
            }
        }
    }

    private fun setCard8(){
        //Declarar MediaPlayer
        var mediaPlayer8: MediaPlayer? = MediaPlayer.create(this, R.raw.nahpito)
        //Declaración de elementos
        val sound8CV : CardView = findViewById(R.id.sound8)
        //Ajustar background
        sound8CV.setBackgroundResource(R.drawable.badumtss)
        //Reproducción de sonido cuando se presiona CV
        sound8CV.setOnClickListener{
            if (mediaPlayer8!!.isPlaying){
                mediaPlayer8?.pause()
                mediaPlayer8?.seekTo(0)
            }
            else{
                mediaPlayer8?.start()
            }
        }
    }

    /////////////
}