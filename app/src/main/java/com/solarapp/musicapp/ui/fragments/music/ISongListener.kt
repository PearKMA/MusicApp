package com.solarapp.musicapp.ui.fragments.music

import com.solarapp.musicapp.models.Song

interface ISongListener {
    fun onSongClicked(item: Song)
    fun onDoubleClicked()
}