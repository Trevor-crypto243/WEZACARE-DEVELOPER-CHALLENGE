package com.example.wezacare_developer_challenge.viewmodels

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.wezacare_developer_challenge.network_data.CharacterApi



import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterApiServiceTest {

    private val characterApiService = CharacterApi.retrofitService

    /**
     * This test uses the characterApi from the character service class to test the number of
     * itesm retrieevde from the API
     * */
    @Test
    fun `test getCharacters`() {
        runBlocking {
            val characters = characterApiService.getCharacters()
            assertEquals(402, characters.size)
        }
    }
}
