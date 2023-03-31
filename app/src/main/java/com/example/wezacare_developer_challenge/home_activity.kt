package com.example.wezacare_developer_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wezacare_developer_challenge.databinding.ActivityHomeBinding
import com.example.wezacare_developer_challenge.network_data.Character_
import com.example.wezacare_developer_challenge.viewmodels.CharacterViewModel
import com.facebook.drawee.backends.pipeline.Fresco

class home_activity : AppCompatActivity() {
    private lateinit var char_adapter: CharacterAdapter
    private lateinit var adapter: ArrayAdapter<Character_>



    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("WEZACARE DEVELOPER CHALLENGE")
        Fresco.initialize(this)
        val viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        viewModel.result.observe(this) { characterList ->
            char_adapter.differ.submitList(characterList)
            adapter.notifyDataSetChanged()
        }



        viewModel.status.observe(this) { status ->
            // Update the statusTextView with the new status value
            binding.status.text = "$status"
            if (binding.status.text.toString() == "success") {
                binding.status.visibility = View.GONE
            }
        }

        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this, search::class.java)
            startActivity(intent)
        }

        char_adapter = CharacterAdapter()
        binding.recyclerview.apply{
            layoutManager = LinearLayoutManager(this@home_activity)
            adapter = char_adapter
            setHasFixedSize(true)
            char_adapter.differ.submitList(viewModel.result)

        }

    }


    private fun <T> AsyncListDiffer<T>.submitList(result: LiveData<List<T>>) {
        result.observeForever { newList ->
            this.submitList(newList)
        }
    }}