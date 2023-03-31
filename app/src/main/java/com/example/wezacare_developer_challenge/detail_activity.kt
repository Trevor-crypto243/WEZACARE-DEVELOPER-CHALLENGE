package com.example.wezacare_developer_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wezacare_developer_challenge.databinding.ActivityDetailBinding
import com.example.wezacare_developer_challenge.network_data.Character_
import com.facebook.drawee.backends.pipeline.Fresco

class detail_activity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setTitle("WEZACARE DEVELOPER CHALLENGE")
        Fresco.initialize(this)//Initilaising the frescoo library for holding the image


        val character_details = intent.getSerializableExtra("my_data") as Character_
        binding.imageView.setImageURI(character_details.image)
        binding.actorValue.text = character_details.actor
        binding.aliveValue.text = character_details.alive.toString()
        binding.alternateActorValue.text = character_details.alternateActors.toString()
        binding.alternateNamesValue.text = character_details.alternateNames.toString()
        binding.ancestryValue.text = character_details.ancestry
        binding.genderValue.text = character_details.gender
        binding.eyecolorValue.text = character_details.eyeColour
        binding.houseValue.text = character_details.house
        binding.nameValue.text = character_details.name
        binding.patronusValue.text = character_details.patronus
        binding.speciesValue.text = character_details.species
        binding.wizardValue.text = character_details.wizard.toString()
        binding.studentValue.text = character_details.hogwartsStudent.toString()
        binding.staffValue.text = character_details.hogwartsStaff.toString()
        binding.haircolorValue.text = character_details.hairColour
        binding.dobValue.text = character_details.dateOfBirth
        binding.yobValue.text = character_details.yearOfBirth.toString()

    }
}