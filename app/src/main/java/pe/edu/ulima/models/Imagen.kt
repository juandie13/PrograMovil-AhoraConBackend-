package pe.edu.ulima.models

import com.google.gson.annotations.SerializedName

data class Imagen(
    var id: Int = 0,
    var url: String = "",
    var usuarioId: Int = 0,
)