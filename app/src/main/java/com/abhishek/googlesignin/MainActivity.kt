package com.abhishek.googlesignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.abhishek.googlesignin.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //view Binding
    private lateinit var binding: ActivityMainBinding

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    //Constants
    private companion object{
        private const val RC_SIGN_IN = 100
        private const val TAG ="GOOGLE_SIGN_IN_TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        //Configure the google SignIn
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail() // we only need email from google account
            .build()
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions)
        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //Google SignIN Button, Click to begin Google SignIn
        binding.googleSignInBtn.setOnClickListener {
            //begin Google SignIn
            Log.d(TAG,"onCreate: begin GoogleSignIn")
            val intent = googleSignInClient.signInIntent
                startActivityForResult( intent,RC_SIGN_IN)
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser!= null){

            startActivity(Intent(this@MainActivity,BottomNavigation::class.java))
            finish()
        }

    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            //Result returned from launching the Intent from GoggleSignApi.getSignInIntent(...):
        if(requestCode == RC_SIGN_IN){
            Log.d(TAG,"onActivityResult: Google SignIn intent result")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                //Google SignIn success, new auth with firebase
                val account = accountTask.getResult(ApiException::class.java)
                FirebaseAuthWithGoogleAccount(account)
            }
            catch (e:Exception){
                //failed Google SignIn
                Log.d(TAG,"onActivityResult:${e.message}")
            }
        }



    }

    private fun FirebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
        Log.d(TAG, "FirebaseAuthWithGoogleAccount: begin firebase auth with google account")
        val credential = GoogleAuthProvider.getCredential(account?.idToken,null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                //login success
                Log.d(TAG, "FirebaseAuthWithGoogleAccount:LoggedIn")
                //get loggedIn User
                val firebaseUser = firebaseAuth.currentUser
                //get user info
                val uid = firebaseUser!!.uid
                val email = firebaseUser.email

                Log.d(TAG, "FirebaseAuthWithGoogleAccount: uid:$uid")
                Log.d(TAG, "FirebaseAuthWithGoogleAccount: Email:$email")

                //check if user is new or existing
                if(authResult.additionalUserInfo!!.isNewUser){
                    //user is new -Account created
                    Log.d(TAG, "FirebaseAuthWithGoogleAccount: Account created....\n$email")
                    Toast.makeText(this@MainActivity,"Account created....\n$email",Toast.LENGTH_SHORT).show()

                }
                else{
                    //existing user - loggedIn
                    Log.d(TAG, "FirebaseAuthWithGoogleAccount: Existing user....\n$email")
                    Toast.makeText(this@MainActivity,"LoggedIn....\n$email",Toast.LENGTH_SHORT).show()

                }
                //start profile Activity
                    startActivity(Intent(this@MainActivity,BottomNavigation::class.java))
                    finish()
            }
            .addOnFailureListener{  e->
                Log.d(TAG, "FirebaseAuthWithGoogleAccount: Login Failed due to ${e.message}")
                Toast.makeText(this@MainActivity,"Login Failed due to ${e.message}",Toast.LENGTH_SHORT).show()

            }

    }

}
