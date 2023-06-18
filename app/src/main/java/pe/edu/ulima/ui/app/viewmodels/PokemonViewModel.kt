package pe.edu.ulima.ui.app.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.activities.configs.BackendClient
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.models.Pokemon
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.PokemonService
import pe.edu.ulima.services.SeguidorService
import pe.edu.ulima.services.UserService
import kotlin.concurrent.thread

class PokemonViewModel : ViewModel() {
    private val _pokemons = mutableStateOf<List<Pokemon>?>(
        listOf()
    )
    val pokemons get() = _pokemons.value
    fun setPokemons() {
        val apiService = BackendClient.buildService(PokemonService::class.java)
        thread {
            try {
                val response = apiService.fetchAll("", "").execute()
                if (response.isSuccessful) {
                    //println(response.body())
                    _pokemons.value = response.body()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private val _imagenes = mutableStateOf<List<Imagen>?>(
        listOf()
    )
    val imagenes get() = _imagenes.value
    fun setImagenes(userId: Int) {
        _imagenes.value = ImagenService.fetchByUserId(userId)
    }

    fun getImagenById(id: Int): String {
        return UserService.fetchOne(id).imagen
    }

    fun getNameById(id: Int): String {
        return UserService.fetchOne(id).nombre
    }

    private val _selectedId = mutableStateOf<Int?>(
        null
    )
    val selectedId get() = _selectedId.value
    fun setSelectedId(selectedId: Int) {
        _selectedId.value = selectedId
    }

    private val _seguidores = MutableLiveData<Int>(
        0
    )
    val seguidores get() = _seguidores
    fun setSeguidores(userId: Int) {
        _seguidores.postValue(SeguidorService.countByUserId(userId))
    }

    private val _seguidos = MutableLiveData<Int>(
        0
    )
    val seguidos get() = _seguidos
    fun setSeguidos(userId: Int) {
        _seguidos.postValue(SeguidorService.countSeguidosBySeId(userId))
    }
}