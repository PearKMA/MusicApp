package com.solarapp.musicapp.ui.fragments.music

import android.view.LayoutInflater
import com.solarapp.musicapp.bases.AdapterBase
import com.solarapp.musicapp.models.Song

class AdapterSongs(inflater: LayoutInflater, resLayout: Int) : AdapterBase<Song>(
    inflater,
    resLayout
), ISongListener {


    override fun onSongClicked() {

    }

    override fun onDoubleClicked() {

    }


}