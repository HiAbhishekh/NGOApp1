package com.abhishek.googlesignin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import com.abhishek.googlesignin.databinding.ActivityProfile3Binding
import com.abhishek.googlesignin.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentProfileBinding.inflate(layoutInflater)

            bind.firstcard.setOnClickListener{
                val intent = Intent(this@ProfileFragment.requireContext(),ProfileActivity3::class.java)
                startActivity(intent)

            }

        return  bind.root
    }
    companion object {
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
