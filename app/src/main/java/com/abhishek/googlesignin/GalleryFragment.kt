package com.abhishek.googlesignin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notification, container, false)
    }


    companion object{
        fun newInstance( ) =
            GalleryFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}