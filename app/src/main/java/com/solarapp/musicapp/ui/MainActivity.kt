package com.solarapp.musicapp.ui

import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.solarapp.musicapp.bases.ActivityBase
import com.solarapp.musicapp.databinding.ActivityMainBinding
import com.solarapp.musicapp.ui.album.FragmentAlbums
import com.solarapp.musicapp.ui.artist.FragmentArtist
import com.solarapp.musicapp.ui.music.FragmentSong
import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage
import kotlinx.android.synthetic.main.activity_main.*
import android.R
import android.widget.Toast
import android.os.Bundle
import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : ActivityBase<ActivityMainBinding>(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var adapter: MainPagerAdapter
    private val fmSong = FragmentSong()
    private val fmAlbum = FragmentAlbums()
    private val fmArtist = FragmentArtist()

    override fun initAct() {
        super.initAct()
        setSupportActionBar(toolbar)
        binding.navView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            com.solarapp.musicapp.R.string.navigation_drawer_open,
            com.solarapp.musicapp.R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setCheckedItem(com.solarapp.musicapp.R.id.nav_song)

        adapter = MainPagerAdapter(supportFragmentManager,
            fmSong, fmAlbum, fmArtist)
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_song -> {

            }
            R.id.nav_album -> {

            }
            R.id.nav_artist -> {

            }
            R.id.nav_share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun getLayoutId(): Int {
        return com.solarapp.musicapp.R.layout.activity_main
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
