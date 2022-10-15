package com.abhishek.googlesignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        supportActionBar?.hide()
        //val imageSlider = findViewById<ImageSlider>(R.id.imageslider)
        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)
        bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_icons8_plus))
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_donate_donation_svgrepo_com))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_baseline_photo_library_24))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_menu13))

        bottomNavigation.setOnClickMenuListener {
            when (it.id) {
                0 -> {

                    replaceFragment(HomeFragment.newInstance())

                }
                1 -> {

                    replaceFragment(DonateFragment.newInstance())

                }

                2 -> {


                    replaceFragment(GalleryFragment.newInstance())
                }
                3 -> {

                    replaceFragment(ProfileFragment.newInstance())
                }
                else -> {

                    replaceFragment(HomeFragment.newInstance())
                    finish()

                }
            }

        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

}