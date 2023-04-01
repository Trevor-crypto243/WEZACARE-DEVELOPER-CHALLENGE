package com.example.wezacare_developer_challenge
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.wezacare_developer_challenge.network_data.CharacterApi
import com.example.wezacare_developer_challenge.network_data.CharacterApiService
import com.example.wezacare_developer_challenge.network_data.Character_
import com.example.wezacare_developer_challenge.network_data.Wand
import com.example.wezacare_developer_challenge.viewmodels.CharacterViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }
}
