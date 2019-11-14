package com.solarapp.musicapp.ui.fragments.music.artist

import android.os.Bundle
import com.solarapp.musicapp.App
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.AdapterBase
import com.solarapp.musicapp.bases.FragmentBase
import com.solarapp.musicapp.dao.SystemDao
import com.solarapp.musicapp.databinding.FragmentArtistBinding
import com.solarapp.musicapp.models.Artist
import com.solarapp.musicapp.models.Song
import com.solarapp.musicapp.ui.MainActivity
import com.solarapp.musicapp.ui.fragments.artist.IArtistListener

class FragmentArtist : FragmentBase<FragmentArtistBinding>(),IArtistListener,
    AdapterBase.ListItemListener{


    private lateinit var adapter: AdapterBase<Song>


    override fun getTitle(): String {
        return App.instance!!.getString(R.string.mnu_artist)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_artist
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = AdapterBase(activity!!.layoutInflater, R.layout.item_song)
        binding.rvArtist.adapter = adapter
        adapter.listener = this
        SystemDao(context!!).apply {
            adapter.setData(getMedia(Song::class.java))
        }

    }


    override fun onArtistClicked(item: Artist) {
        (activity as MainActivity).service?.apply {
            data = adapter.getData()
            create(adapter.getData()?.indexOf(item) ?: 0)
        }
    }
}