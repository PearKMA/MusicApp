package com.solarapp.musicapp.ui

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.solarapp.musicapp.bases.ActivityBase
import com.solarapp.musicapp.databinding.ActivityMainBinding
import com.solarapp.musicapp.ui.album.FragmentAlbums
import com.solarapp.musicapp.ui.artist.FragmentArtist
import com.solarapp.musicapp.ui.music.FragmentSong
import kotlinx.android.synthetic.main.activity_main.*


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
            com.solarapp.musicapp.R.id.nav_song -> {
                binding.navView.setCheckedItem(com.solarapp.musicapp.R.id.nav_song)
            }
            com.solarapp.musicapp.R.id.nav_album -> {
                binding.navView.setCheckedItem(com.solarapp.musicapp.R.id.nav_album)
            }
            com.solarapp.musicapp.R.id.nav_artist -> {
                binding.navView.setCheckedItem(com.solarapp.musicapp.R.id.nav_artist)
            }
            com.solarapp.musicapp.R.id.other -> Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
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
