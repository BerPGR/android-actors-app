package br.com.actorsapp.repository

import br.com.actorsapp.model.Character
import br.com.actorsapp.retrofit.CharacterApi
import retrofit2.Response

class CharacterRepo(
    private val characterApi: CharacterApi
) {

    suspend fun getCharacters(): List<Character> {
        return characterApi.getCharactersList()
    }
}