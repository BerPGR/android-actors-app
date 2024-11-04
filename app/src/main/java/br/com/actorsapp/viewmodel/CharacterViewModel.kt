package br.com.actorsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.actorsapp.model.Character
import br.com.actorsapp.repository.CharacterRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    val characterRepo: CharacterRepo
): ViewModel() {

    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
        get() = _state

    init {
        viewModelScope.launch {
            val characters = characterRepo.getCharacters()
            _state.value = characters
        }
    }
}