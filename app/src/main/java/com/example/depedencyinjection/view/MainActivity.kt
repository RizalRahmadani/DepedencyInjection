package com.example.depedencyinjection.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.depedencyinjection.R
import com.example.depedencyinjection.databinding.ActivityMainBinding
import com.example.depedencyinjection.viewmodel.ViewModelMakeup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var makeupAdapter : MakeupAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }
    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeup::class.java)
        viewModel.callApiMakeup()
        viewModel.getliveDataMakeup().observe(this, Observer {
            makeupAdapter = MakeupAdapter(it)
            if ( it != null){
                binding.rvmakeup.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvmakeup.adapter = MakeupAdapter(it)

            }

        })
    }
}