package pe.edu.ulima.models.demo

import androidx.compose.ui.text.font.FontWeight

data class PokemonListItem(
    val generation_id: Int,
    val generation_name: String,
    val height: Double,
    val id: Int,
    val image_url: String,
    val name: String,
    val number: Int,
    val weight: Double
)
