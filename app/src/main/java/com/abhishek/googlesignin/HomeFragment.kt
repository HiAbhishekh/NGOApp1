package com.abhishek.googlesignin

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_profile3.*



class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
       var v = inflater.inflate(R.layout.fragment_home, container, false)
        //val imageSlider = v.findViewById<ImageSlider>(R.id.imageslider)
       // val imageList = ArrayList<SlideModel>()

       // imageList.add(SlideModel("https://lh3.googleusercontent.com/pw/AM-JKLUJvLEutjbIN5fuaToxh5P1c6Clhdd_4oFtFaJcaH5VIdsVk0GAXhWe4_dMritJujH8DzXi5eBSAF1fgYAGrUU9MudGFpkDIVkIJ8Dlvjf3Rla-1_CJRKR8lU4TpBmPXQXsx7uK_RuoArOSGSJy3sJn=s500-no?authuser=0",""))
       // imageList.add(SlideModel("https://www.alansilvestri.com/webart/press/370x208x126.jpg.pagespeed.ic.9buaJWeHMJ.webp",""))
       // imageList.add(SlideModel("https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510_960_720.jpg",""))
       // imageList.add(SlideModel("https://cdn.mos.cms.futurecdn.net/78rRqq9SmQfBkBqB3mWgSj-970-80.jpeg.webp",""))

       //imageSlider.setImageList(imageList)

       return v

        }

    companion object {
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }

}


