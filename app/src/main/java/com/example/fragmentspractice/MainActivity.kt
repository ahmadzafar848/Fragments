package com.example.fragmentspractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentspractice.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
        if (savedInstanceState == null) {
            // Add the HomeFragment only if the activity is being created for the first time
            replaceFragment(HomeFragment())
        }

        binding.homeIcon.setOnClickListener{
         replaceFragment(HomeFragment())
        }

        binding.paymentIcon.setOnClickListener{
         replaceFragment(PaymentFragment())
        }

        binding.moreIcon.setOnClickListener{
            replaceFragment(MoreFragment())
        }
    }

//    fun replaceFragment(fragment: Fragment) {
//         fragmentManager= supportFragmentManager // Use supportFragmentManager for AndroidX
//
//        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.mainActivityFragmentContainer, fragment)
//        transaction.addToBackStack(null) // Optionally, add the transaction to the back stack
//        transaction.commit()
//    }
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivityFragmentContainer, fragment)
            .addToBackStack(null) // Optionally, add the transaction to the back stack
            .commit()
    }

}


