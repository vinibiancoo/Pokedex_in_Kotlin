package br.com.vinicius.pokedex_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.pokedex_kotlin.R
import br.com.vinicius.pokedex_kotlin.api.PokemonRepository
import br.com.vinicius.pokedex_kotlin.domain.Pokemon
import br.com.vinicius.pokedex_kotlin.domain.PokemonType
import br.com.vinicius.pokedex_kotlin.viewmodel.PokemonViewModel
import br.com.vinicius.pokedex_kotlin.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemon)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }
    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstancesState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }
    private fun loadRecyclerView(pokemons: List<Pokemon?>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}