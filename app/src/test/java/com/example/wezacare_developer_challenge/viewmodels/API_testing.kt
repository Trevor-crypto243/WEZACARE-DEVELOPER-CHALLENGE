package com.example.wezacare_developer_challenge.viewmodels

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.wezacare_developer_challenge.network_data.CharacterApi



import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterApiServiceTest {

    private val characterApiService = CharacterApi.retrofitService

    @Test
    fun `test getCharacters`() {
        runBlocking {
            val characters = characterApiService.getCharacters()
            assertEquals(25, characters.size)
        }
    }
}
