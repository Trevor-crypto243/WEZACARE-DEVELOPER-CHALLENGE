package com.example.wezacare_developer_challenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wezacare_developer_challenge.network_data.CharacterApi
import com.example.wezacare_developer_challenge.network_data.Character_
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _result = MutableLiveData<List<Character_>>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    val result : LiveData<List<Character_>> = _result

    init {
        getCharacterPhotos()
    }

    //function to get the character details through a coroutine
    fun getCharacterPhotos() {
        viewModelScope.launch {
            try {
                val listResult = CharacterApi.retrofitService.getCharacters()
                _status.value = "success"
                _result.value = listResult

            } catch (e: Exception) {
                _status.value = "Failure: network error... check that you are connected and try again"
            }
        }
    }
}