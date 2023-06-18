package pe.edu.ulima.ui.app.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.Usuario
import pe.edu.ulima.services.UserService
import java.util.regex.Matcher
import java.util.regex.Pattern

class ProfileViewModel: ViewModel() {
    private val _id = MutableLiveData<Int>(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String){
        _contrasenia.postValue(it)
    }

    private val _newContrasenia = MutableLiveData<String>("")
    var newContrasenia: LiveData<String> = _newContrasenia
    fun updateNewContrasenia(it: String){
        _newContrasenia.postValue(it)
    }

    private val _repeatContrasenia = MutableLiveData<String>("")
    var repeatContrasenia: LiveData<String> = _repeatContrasenia
    fun updateRepeatContrasenia(it: String){
        _repeatContrasenia.postValue(it)
    }

    private val _nombre = MutableLiveData<String>("")
    var nombre: LiveData<String> = _nombre
    fun updateNombre(it: String){
        _nombre.postValue(it)
    }

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String){
        _correo.postValue(it)
    }

    private val _imagen = MutableLiveData<String>("")
    var imagen: LiveData<String> = _imagen
    fun updateImagen(it: String){
        _imagen.postValue(it)
    }

    var camposHabilitados by mutableStateOf(false)
        private set

    var conteo = 0;
    fun updateData() {
        camposHabilitados = !camposHabilitados
        var result = false;

        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val email = correo.value
        val matcher: Matcher = pattern.matcher(email)
        val matchFound: Boolean = matcher.matches()

        if(!camposHabilitados) {
            if(UserService.validateCorreo(correo.value!!, id.value!!)) {
                println("Correo ya existe")
                updateMensaje("Error: Correo ya existe")
            }
            else {
                result = true
            }

            if(UserService.validateUsername(usuario.value!!, id.value!!)) {
                println("Usuario ya existe ")
                updateMensaje("Error: Usuario ya existe")
                result = false
            }

            if (!matchFound) {
                updateMensaje("Error: El correo no tiene un formato válido")
                result = false
            }

            if(result) {
                updateMensaje("Perfil actualizado")
                camposHabilitados = false
            }
        }
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun validatePassword() {
        if(contrasenia.value != "" && newContrasenia.value != "" && repeatContrasenia.value != "") {
            if(contrasenia.value == newContrasenia.value) {
                updateMensaje("Error: La contraseña nueva no puede ser igual a la actual")
            }
            else if(newContrasenia.value != repeatContrasenia.value) {
                updateMensaje("Error: Las contraseñas no coinciden")
            }
            else {
                updateMensaje("Contraseña actualizada")
            }
        }
    }

    fun setUsuario(id: Int){
        val usuario = UserService.fetchOne(id)
        this.updateUsuario(usuario.usuario)
        this.updateCorreo(usuario.correo)
        this.updateNombre(usuario.nombre)
        this.updateImagen(usuario.imagen)
        this.updateId(usuario.id)
    }
}