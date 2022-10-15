package com.abhishek.googlesignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhishek.googlesignin.databinding.ActivityProfile3Binding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_profile3.*

class ProfileActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityProfile3Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var abAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfile3Binding.inflate(layoutInflater)
        setContentView( binding.root)
        supportActionBar?.hide()
        abAuth = FirebaseAuth.getInstance()
        val currentUser = abAuth.currentUser
        name1.text = currentUser?.displayName

        Glide.with(this).load(currentUser?.photoUrl).into(profileimage);

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        binding.loggoutbtn.setOnClickListener{
            firebaseAuth.signOut()
            checkUser()
        }

    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser==null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        else{
            val email = firebaseUser.email
            binding.emailTv.text = email


        }

    }
}