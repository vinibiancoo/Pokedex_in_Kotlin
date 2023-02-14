package br.com.vinicius.pokedex_kotlin.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.pokedex_kotlin.R
import br.com.vinicius.pokedex_kotlin.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindview(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindview(item: Pokemon) =  with(itemView){
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvPokemonName = findViewById<TextView>(R.id.tvPokemonName)
            val tvPokemonNum = findViewById<TextView>(R.id.tvPokemonNum)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)


            tvPokemonNum.text = "Nº ${item.number}"
            tvPokemonName.text = item.name
            tvType1.text = item.types[0].name

            if (item.types.size > 1){
                tvType2.visibility = View.VISIBLE
                tvType1.text = item.types[1].name
            }else{
                tvType2.visibility = View.GONE
            }
            }
        }

    }