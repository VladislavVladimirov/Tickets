package com.myapp.tickets.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapp.tickets.databinding.ActivityAppBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AppActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}

