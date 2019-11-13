package com.solarapp.musicapp.ui.fragments.music.album

import com.solarapp.musicapp.App
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.FragmentBase
import com.solarapp.musicapp.databinding.FragmentAlbumBinding

class FragmentAlbums : FragmentBase<FragmentAlbumBinding>() {
    override fun getTitle(): String {
        return App.instance!!.getString(R.string.mnu_album)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_album
    }

}