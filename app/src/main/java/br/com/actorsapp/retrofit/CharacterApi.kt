package br.com.actorsapp.retrofit

import br.com.actorsapp.model.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET("api/characters")
    suspend fun getCharactersList(): List<Character>

}