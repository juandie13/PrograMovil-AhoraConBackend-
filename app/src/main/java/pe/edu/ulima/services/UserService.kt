package pe.edu.ulima.services

import pe.edu.ulima.models.Pokemon
import pe.edu.ulima.models.Usuario
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.regex.Matcher
import java.util.regex.Pattern

/*
class UserService {

    companion object {

        val usuarios = listOf(
            Usuario (1, "admin","123", "Super Administrador", "root@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/1.png"),
            Usuario (2, "pepe","123", "Pepe Valdivia", "pepe@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png"),
            Usuario (3, "sila","123", "Sila Esculapia", "sila@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png"),
            Usuario (4, "mateo","123", "Mateo Sanchez", "mateo@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png"),
            Usuario (5, "marcos","123", "Marcos Perez", "marcos@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png"),
            Usuario (6, "lucas","123", "Lucas Moura", "lucas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png"),
            Usuario (7, "juan","123", "Juan Vargas", "juan@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png"),
            Usuario (8, "judas","123", "Judas Iscariote", "judas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png"),
            Usuario (9, "tito","123", "Tito Garcia", "tito@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
            Usuario (10, "filemon","123", "Filemon Peluche", "filemon@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
        )

        fun validate(usuario: String, contrasenia: String): Int {
            var id = 0
            for(u in usuarios){
                if(u.usuario == usuario && u.contrasenia == contrasenia){
                    id = u.id
                }
            }
            return id
        }

        fun fetchOne(id: Int): Usuario{
            var usuario = Usuario()
            for(u in usuarios){
                if(u.id == id){
                    usuario = u
                }
            }
            return usuario
        }

        fun validateCorreo(correo: String, id: Int): Boolean{

            var found = false
            var usuario = Usuario()
            for(u in usuarios){
                if(u.correo == correo){
                    usuario = u
                    found = true
                }
            }
            if(usuario.id==id) found = false
            return found
        }

        fun validateUsername(username: String, id: Int): Boolean{
            var found = false
            var usuario = Usuario()
            for(u in usuarios){
                if(u.usuario == username){
                    usuario = u
                    found = true
                }
            }
            if(usuario.id==id) found = false
            return found
        }
    }
}
*/

interface UserService {

    @POST("/user/create")
    fun user_create(
        @Path("user") user: String,
        @Path("password") password: String,
        @Path("email") email: String,
        @Path("image_url") image_url: String
    ): Call<Usuario>

    @POST("/user/reset_password")
    fun validate_password(@Path("email") email: String): Call<Usuario>

    @POST("/user/validate")
    fun validate(@Path("user") user: String, @Path("password") password: String): Call<Usuario>

    fun fetchOne(
        @Path("id") id: Int
    ): Call<Usuario>
}

