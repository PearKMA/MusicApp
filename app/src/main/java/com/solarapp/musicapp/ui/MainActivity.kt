package com.solarapp.musicapp.ui

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.TabHost
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.solarapp.musicapp.R
import com.solarapp.musicapp.bases.ActivityBase
import com.solarapp.musicapp.databinding.ActivityMainBinding
import com.solarapp.musicapp.ui.album.FragmentAlbums
import com.solarapp.musicapp.ui.artist.FragmentArtist
import com.solarapp.musicapp.ui.music.FragmentSong
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : ActivityBase<ActivityMainBinding>(),
    NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {



    private val PERMISSIONS = arrayOf(
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    private lateinit var adapter: MainPagerAdapter
    private val fmSong = FragmentSong()
    private val fmAlbum = FragmentAlbums()
    private val fmArtist = FragmentArtist()


    override fun initAct() {
        super.initAct()
        doRequestPermission(PERMISSIONS)

        setSupportActionBar(toolbar)
        setUpDrawerAndViewPager()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mnu_searchview,menu)
        val search = menu?.findItem(R.id.action_search)?.actionView as androidx.appcompat.widget.SearchView
        search.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        //query
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }

    private fun setUpDrawerAndViewPager() {
        binding.navView.setNavigationItemSelectedListener(this::onNavigationItemSelected)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setCheckedItem(R.id.nav_song)

        adapter = MainPagerAdapter(
            supportFragmentManager,
            fmSong, fmAlbum, fmArtist
        )
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.tabs.addOnTabSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var idItem = 0

        when (p0.itemId) {
            R.id.nav_song -> {
                idItem = 0
            }
            R.id.nav_album -> {
                idItem = 1
            }
            R.id.nav_artist -> {
                idItem = 2
            }
            R.id.other -> Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
        }
        binding.tabs.getTabAt(idItem)?.select()
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        binding.viewPager.setCurrentItem(p0!!.position)

        binding.navView.setCheckedItem(when(p0.position){
            0 -> R.id.nav_song
            1-> R.id.nav_album
            2 -> R.id.nav_artist
            else -> R.id.nav_song
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
