package pe.edu.ulima.models

import com.google.gson.annotations.SerializedName

data class Seguido(
    var id: Int = 0,
    @SerializedName("users_id")
    var usuarioId: Int = 0,
    @SerializedName("pokemon_id")
    var seguidorId: Int = 0,
)