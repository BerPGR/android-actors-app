package br.com.actorsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.actorsapp.model.Character
import br.com.actorsapp.repository.CharacterRepo
import br.com.actorsapp.retrofit.CharacterApi
import br.com.actorsapp.retrofit.RetrofitInstance
import br.com.actorsapp.ui.theme.ActorsAppTheme
import br.com.actorsapp.viewmodel.CharacterViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActorsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val characterApi = RetrofitInstance.provideApi(RetrofitInstance.provideRetrofit())
                    val characterRepository = CharacterRepo(characterApi)
                    val characterViewModel = CharacterViewModel(characterRepository)
                    MainScreen(viewModel = characterViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CharacterViewModel) {
    val state by viewModel.state.collectAsState()
    ActorsScreen(characters = state)
}

@Composable
fun ActorsScreen(characters: List<Character>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(characters) { item ->
            CardItem(character = item)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(character: Character) {
    Column {
        
        GlideImage(model = character.image, contentDescription = "Image",
            modifier = Modifier
                .padding(4.dp)
                .size(width = 140.dp, height = 180.dp)
        )
        Text(text = character.actor_name, fontSize = 20.sp)
    }
}