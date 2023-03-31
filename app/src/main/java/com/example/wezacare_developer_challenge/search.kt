package com.example.wezacare_developer_challenge

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wezacare_developer_challenge.databinding.ActivitySearchBinding
import com.example.wezacare_developer_challenge.network_data.Character_
import com.example.wezacare_developer_challenge.viewmodels.CharacterViewModel

class search : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchView: SearchView
    private lateinit var listView: ListView
    private lateinit var adapter: Char_adapter
    private val characterList: MutableList<Character_> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("Search by name or house...")

        val viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        listView = binding.listView
        searchView = binding.searchview

        // Set up the adapter
        adapter = Char_adapter(this, characterList)
        listView.adapter = adapter

        viewModel.result.observe(this, Observer { resultList ->
            // Clear the list and add the new data
            characterList.clear()
            characterList.addAll(resultList)
            adapter.notifyDataSetChanged()
        })


        // Set up search view listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { text ->
                    val filteredList = characterList.filter { character_ ->
                        character_.name.contains(text, true) || character_.house.contains(text, true)
                    }
                    adapter.clear()
                    adapter.addAll(filteredList)
                }
                return true
            }
        })

    }
}
private class Char_adapter(context: Context, characters: List<Character_>) :
    ArrayAdapter<Character_>(context, android.R.layout.simple_list_item_1, characters) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val character = getItem(position)
        val text = "${character?.name}, ${character?.house}"
        (view as TextView).text = text
        return view
    }
}