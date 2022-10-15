package com.abhishek.googlesignin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhishek.googlesignin.databinding.FragmentEventBinding


class DonateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentEventBinding.inflate(layoutInflater)

        return  bind.root
    }

        companion object{
        fun newInstance( ) =
            DonateFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}