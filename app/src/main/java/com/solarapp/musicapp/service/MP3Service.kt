package com.solarapp.musicapp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.lifecycle.MutableLiveData
import com.solarapp.musicapp.R
import com.solarapp.musicapp.models.Song

class MP3Service : Service() {

    private val NOTIFICATION_ID: Int = 1509
    var data: List<Song>? = null
    var player: MediaPlayer? = null
    var index = 0
    val item = MutableLiveData<Song>()
    val position = MutableLiveData<Int>()
    val isPlaying = MutableLiveData<Boolean>()
    private var thread: Thread? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {

        return MP3Binder(this)
    }

    private fun pushNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                javaClass.simpleName,   //giong dong 40
                javaClass.simpleName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(this, javaClass.simpleName)
        notification.setSmallIcon(R.mipmap.ic_launcher)
        notification.setContentTitle("App MP3")
        notification.setContentText(data?.get(index)?.title)
        startForeground(NOTIFICATION_ID, notification.build())
    }

    fun create(index: Int) {
        this.index = index
        player?.release()
        player = MediaPlayer.create(this, Uri.parse(data?.get(index)?.data))
        player?.start()

        pushNotification()
        item.postValue(data?.get(index))

        if (thread == null) {
            thread = Thread {
                while (true) {

                }
            }
        }
    }

    fun pause() {
        player?.pause()
        isPlaying.postValue(false)

    }

    fun start() {
        player?.start()
        isPlaying.postValue(true)
    }

    class MP3Binder(val service: MP3Service) : Binder()
}