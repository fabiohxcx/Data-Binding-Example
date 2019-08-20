package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityDataBindingBinding
import com.example.aboutme.databinding.ActivityMainBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    private val myName: MyName = MyName("Fabio Hideki")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        binding.myName = myName

        binding.btDone.setOnClickListener {
            addNickname(it)
        }


    }

    private fun addNickname(it: View?) {


        binding.apply {

            myName?.nickname = etNickName.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
        }

    }
}
