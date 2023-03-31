package com.example.wezacare_developer_challenge.network_data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



//The base url
private const val BASE_URL = "https://hp-api.onrender.com/api/"

//Moshi object to be used by retrofit
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//public interface to expose the getCharacterMethod
interface CharacterApiService {
    @GET("characters")
    suspend fun getCharacters() : List<Character_>
}

object CharacterApi {
    val retrofitService: CharacterApiService by lazy { retrofit.create(CharacterApiService::class.java) }
}


