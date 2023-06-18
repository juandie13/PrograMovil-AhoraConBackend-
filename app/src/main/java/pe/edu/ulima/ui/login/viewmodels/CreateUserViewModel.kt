package pe.edu.ulima.ui.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.services.UserService
import java.util.regex.Matcher
import java.util.regex.Pattern

class CreateUserViewModel : ViewModel() {

    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String) {
        _usuario.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String) {
        _contrasenia.postValue(it)
    }

    private val _repContrasenia = MutableLiveData<String>("")
    var repContrasenia: LiveData<String> = _repContrasenia
    fun updateRepContrasenia(it: String) {
        _repContrasenia.postValue(it)
    }

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String) {
        _correo.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String) {
        _mensaje.postValue(it)
    }

    fun validatePassword(): Boolean {
        if(contrasenia.value == "" && repContrasenia.value == "") {
            updateMensaje("Error: Las contraseñas están vacías")
            return true
        }
        if(repContrasenia.value != contrasenia.value) {
            updateMensaje("Error: Las contraseñas no coinciden")
            return true
        }
        return false
    }

    fun validateUser():Boolean {
        if(usuario.value ==""){
            updateMensaje("Error: Ingrese un usuario")
            return true
        }
        if(UserService.validateUsername(usuario.value!!, -1)){
            updateMensaje("Error: El usuario ya está en uso")
            return true
        }
        return false
    }

    fun validateCorreo(): Boolean {
        val email = correo.value
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val matcherEmail: Matcher = pattern.matcher(email)
        val matchFoundEmail: Boolean = matcherEmail.matches()

        if (!matchFoundEmail) {
            updateMensaje("Error: Correo no cumple formato")
            return true
        }
        if(UserService.validateCorreo(email!!, -1)){
            updateMensaje("Error: El correo ya está en uso")
            return true
        }

        return false
    }

    fun validateBlanks(): Boolean {
        if(usuario.value =="" && correo.value == "" && contrasenia.value=="" && repContrasenia.value=="") {
            updateMensaje("Error: El formulario está vacío")
            return true
        }
        return false
    }

    fun reset() {
        if(validateBlanks()) return
        if(validateUser()) return
        if(validatePassword()) return
        if(validateCorreo()) return
        updateMensaje("Usuario creado satisfactoriamente")
    }
}