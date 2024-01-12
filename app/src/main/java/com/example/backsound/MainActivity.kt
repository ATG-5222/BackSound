package com.example.backsound

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private lateinit var mediaPlayerList: List<MediaPlayer>
    private lateinit var playButtons: List<Button>
    private lateinit var pauseButtons: List<Button>
    private lateinit var progressBars: List<ProgressBar>
    private lateinit var totalTimeTextViews: List<TextView>
    private lateinit var currentTimeTextViews: List<TextView>
    private lateinit var handlers: List<Handler>
    private lateinit var runnables: List<Runnable>
    // Estado de reproducción de la cantidad de elementos totales
    private val isPlayingList: MutableList<Boolean> = MutableList(4) { false }
    // Inicialmente ninguna pista está en reproducción
    private var currentPlayingIndex = -1
    private lateinit var restartButtons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ------ Metodos de la navbar ------
        closeApp()
        // Evitar que la pantalla se oscurezca
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        // -------- Tarjetas disponibles -------------
        // Inicializar listas de elementos de la interfaz de usuario y otros objetos
        mediaPlayerList = listOf(
            MediaPlayer.create(this, R.raw.necoarc),
            MediaPlayer.create(this, R.raw.thexfiles),
            MediaPlayer.create(this, R.raw.ftsimout),
            MediaPlayer.create(this, R.raw.badumtss),
        )
        playButtons = listOf(
            findViewById(R.id.necoarcPlayButton),
            findViewById(R.id.xfilesPlayButton),
            findViewById(R.id.imoutPlayButton),
            findViewById(R.id.badumPlayButton),
        )
        pauseButtons = listOf(
            findViewById(R.id.necoarcPauseButton),
            findViewById(R.id.xfilesPauseButton),
            findViewById(R.id.imoutPauseButton),
            findViewById(R.id.badumPauseButton),
        )
        progressBars = listOf(
            findViewById(R.id.necoarcProgressBar),
            findViewById(R.id.xfilesProgressBar),
            findViewById(R.id.imoutProgressBar),
            findViewById(R.id.badumProgressBar),
        )
        totalTimeTextViews = listOf(
            findViewById(R.id.necoarcTotalTime),
            findViewById(R.id.xfilesTotalTime),
            findViewById(R.id.imoutTotalTime),
            findViewById(R.id.badumTotalTime),
        )
        currentTimeTextViews = listOf(
            findViewById(R.id.necoarcCurrentTime),
            findViewById(R.id.xfilesCurrentTime),
            findViewById(R.id.imoutCurrentTime),
            findViewById(R.id.badumCurrentTime),
        )
        restartButtons = listOf(
            findViewById(R.id.necoarcRestartButton),
            findViewById(R.id.xfilesRestartButton),
            findViewById(R.id.imoutRestartButton),
            findViewById(R.id.badumRestartButton),
        )
        // Iniciar Handlers
        handlers = List(4) { Handler() }
        // Función para actualizar barra de reproducción
        runnables = List(4) { createRunnable(it) }
        // Configurar listeners para los botones de reproducción
        for (i in 0 until 4) { //Ciclo dependiendo de la cantidad de elementos
            val mediaPlayer = mediaPlayerList[i]
            val playButton = playButtons[i]
            val pauseButton = pauseButtons[i]
            val currentTime = currentTimeTextViews[i]
            val totalTime = totalTimeTextViews[i]
            val progressBar = progressBars[i]
            val restartButton = restartButtons[i]
            mediaPlayer.setOnCompletionListener {
                // Este código se ejecutará cuando el audio termine de reproducirse
                mediaPlayer.seekTo(0) // Reiniciar el audio al principio
                isPlayingList[i] = false
                playButton.visibility = View.VISIBLE
                pauseButton.visibility = View.VISIBLE
                currentTime.visibility = View.GONE
                totalTime.visibility = View.GONE
                progressBar.progress = 0
                handlers[i].removeCallbacks(runnables[i])
                restartButton.visibility = View.GONE
            }
            playButton.setOnClickListener {
                if (currentPlayingIndex != -1 && currentPlayingIndex != i) {
                    // Detener la pista actual antes de reproducir una nueva
                    val currentMediaPlayer = mediaPlayerList[currentPlayingIndex]
                    if (currentMediaPlayer.isPlaying) {
                        currentMediaPlayer.pause()
                        isPlayingList[currentPlayingIndex] = false
                        playButtons[currentPlayingIndex].visibility = View.VISIBLE
                        pauseButtons[currentPlayingIndex].visibility = View.VISIBLE
                        currentTimeTextViews[currentPlayingIndex].visibility = View.GONE
                        totalTimeTextViews[currentPlayingIndex].visibility = View.GONE
                        progressBars[currentPlayingIndex].progress = 0
                        handlers[currentPlayingIndex].removeCallbacks(runnables[currentPlayingIndex])
                    }
                }
                if (!isPlayingList[i]) {
                    mediaPlayer.start()
                    isPlayingList[i] = true
                    playButton.visibility = View.GONE
                    pauseButton.visibility = View.VISIBLE
                    currentTime.visibility = View.VISIBLE
                    totalTime.visibility = View.VISIBLE
                    handlers[i].postDelayed(runnables[i], 0)
                    currentPlayingIndex = i
                    restartButton.visibility = View.GONE
                }
            }
            pauseButton.setOnClickListener {
                if (isPlayingList[i]) {
                    mediaPlayer.pause()
                    isPlayingList[i] = false
                    playButton.visibility = View.VISIBLE
                    pauseButton.visibility = View.GONE
                    currentTime.visibility = View.VISIBLE
                    totalTime.visibility = View.VISIBLE
                    handlers[i].removeCallbacks(runnables[i])
                    currentPlayingIndex = -1 // La pista se pausó no hay pista en reproducción.
                    restartButton.visibility = View.VISIBLE
                }
            }
            restartButton.setOnClickListener {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0) // Reiniciar el audio al principio
                isPlayingList[i] = false
                playButton.visibility = View.VISIBLE
                pauseButton.visibility = View.VISIBLE
                currentTime.visibility = View.GONE
                totalTime.visibility = View.GONE
                progressBar.progress = 0
                handlers[i].removeCallbacks(runnables[i])
                restartButton.visibility = View.GONE
            }
        }
    }

    ////////////////////////////////////////

    // Actualizar la barra de reproducción
    private fun createRunnable(index: Int): Runnable {
        return Runnable {
            val mediaPlayer = mediaPlayerList[index]
            if (mediaPlayer.isPlaying) {
                val currentDuration = mediaPlayer.currentPosition
                val totalDuration = mediaPlayer.duration
                // Mostrar el tiempo actual y total en formato mm:ss
                currentTimeTextViews[index].text = milliSecondsToTimer(currentDuration.toLong())
                totalTimeTextViews[index].text = milliSecondsToTimer(totalDuration.toLong())
                // Actualizar la barra de progreso
                val progress = (currentDuration.toFloat() / totalDuration.toFloat() * 100).toInt()
                progressBars[index].progress = progress
            }
            handlers[index].postDelayed(runnables[index], 1000) // Actualizar cada segundo
        }
    }

    // Convertir el formato de tiempo de la reproducción
    private fun milliSecondsToTimer(milliseconds: Long): String {
        val minutes = ((milliseconds % (1000 * 60 * 60)) / (1000 * 60)).toInt()
        val seconds = ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000).toInt()
        return String.format("%02d:%02d", minutes, seconds)
    }

    // Liberar recursos de MediaPlayer al destruir la actividad
    override fun onDestroy() {
        super.onDestroy()
        for (mediaPlayer in mediaPlayerList) {
            mediaPlayer.release()
        }
    }

    //Cerrar la aplicación
    private fun closeApp() {
        val includeLayout : LinearLayout = findViewById(R.id.footer)
        val closeButton : Button = includeLayout.findViewById(R.id.botonCerrarApp)
        closeButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            System.exit(0)
        }
    }
    ////////////////////////////////////////
}