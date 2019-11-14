package com.solarapp.musicapp.ui.fragments.music

import android.os.Bundle
import com.solarapp.musicapp.App
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.AdapterBase
import com.solarapp.musicapp.bases.FragmentBase
import com.solarapp.musicapp.dao.SystemDao
import com.solarapp.musicapp.databinding.FragmentMusicBinding
import com.solarapp.musicapp.models.Song
import com.solarapp.musicapp.ui.MainActivity

class FragmentSong : FragmentBase<FragmentMusicBinding>(), ISongListener,
    AdapterBase.ListItemListener {


    private lateinit var adapter: AdapterBase<Song>

    override fun getTitle(): String {
        return App.instance!!.getString(R.string.mnu_music)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_music
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = AdapterBase(activity!!.layoutInflater, R.layout.item_song)
        binding.rvSong.adapter = adapter
        adapter.listener = this
        SystemDao(context!!).apply {
            adapter.setData(getMedia(Song::class.java))
        }

    }

    override fun onSongClicked(item: Song) {
        (activity as MainActivity).service?.apply {
            data = adapter.getData()
            create(adapter.getData()?.indexOf(item) ?: 0)
        }
    }

    override fun onDoubleClicked() {

    }
}