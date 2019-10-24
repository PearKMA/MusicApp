package com.solarapp.musicapp.ui.artist

import com.solarapp.musicapp.App
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.FragmentBase
import com.solarapp.musicapp.databinding.FragmentArtistBinding

class FragmentArtist : FragmentBase<FragmentArtistBinding>(){
    override fun getTitle(): String {
        return App.instance!!.getString(R.string.mnu_artist)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_artist
    }

}