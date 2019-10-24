package com.solarapp.musicapp.ui.music

import com.solarapp.musicapp.App
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.FragmentBase
import com.solarapp.musicapp.databinding.FragmentMusicBinding

class FragmentSong : FragmentBase<FragmentMusicBinding>(){
    override fun getTitle(): String {
        return App.instance!!.getString(R.string.mnu_music)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_music
    }

}