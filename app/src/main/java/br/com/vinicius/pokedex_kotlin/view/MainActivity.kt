package br.com.vinicius.pokedex_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.pokedex_kotlin.R
import br.com.vinicius.pokedex_kotlin.domain.Pokemon
import br.com.vinicius.pokedex_kotlin.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)

        val bulbassaur = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                1,
                "Bulbassaur",
                listOf(
                    PokemonType("Fire")
                )
            )
        val pokemons = listOf(bulbassaur, bulbassaur, bulbassaur, bulbassaur, bulbassaur)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}