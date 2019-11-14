package com.solarapp.musicapp.ui.fragments.artist

import com.solarapp.musicapp.models.Artist

interface IArtistListener{
    fun onArtistClicked(item: Artist)
}