package pe.edu.ulima.ui.app.uis

import androidx.compose.ui.graphics.ColorFilter
import android.hardware.camera2.params.BlackLevelPattern
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import pe.edu.ulima.R
import java.util.concurrent.CountDownLatch

// Clase que modela los Sayayines que habrán
data class Sayayin(
    val nombre: String,
    val imageUrl: String
)

//Lista de valores que se utilizarán para obtener las imágenes (en el caso de los pokemon)
val list: List<String> = listOf(
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/1.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/10.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/11.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/12.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/13.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/14.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/15.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/16.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/17.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/18.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/19.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/20.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/21.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/22.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/23.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/24.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/25.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/26.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/27.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/28.png",
    "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/29.png",
)

@Composable
public fun SplashScreen() {

    //Lista mutable de Sayayines

    val sayayines: MutableList<Sayayin> = mutableListOf();

    //Se agregan a los sayayines a la lista mutable
    sayayines.add(
        Sayayin(
            "Kokun 1",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 2",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 3",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 4",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 5",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 6",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 7",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )

    sayayines.add(
        Sayayin(
            "Kokun 8",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 9",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 10",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 11",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )
    sayayines.add(
        Sayayin(
            "Kokun 12",
            "https://static.wikia.nocookie.net/dragonball/images/c/c0/Son_Goku_en_Super_Hero.png/revision/latest/scale-to-width-down/222?cb=20220302091733&path-prefix=es"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        contentAlignment = Alignment.Center
    )
    //Se crearan un row que dentro contendrá 4 rows los cuales contendrán cada una de las secciones
    {
        Column(
        ) {
            Row()
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    //Imagen del perfil de la cuenta
                    Image(
                        painter = painterResource(id = R.drawable.pokemontrainer),
                        contentDescription = "pokemontrainer",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        alignment = Alignment.Center
                    )
                    //Nombre de la cuenta de instagram
                    Text(text = "Entrenadora", fontWeight = FontWeight.Bold)
                    Text(text = "Pokemon", fontWeight = FontWeight.Bold)
                }
                //Aquí irán las publicaciones,seguidos y seguidores
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(text = "52", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Publicaciones")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(text = "52", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Seguidos")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(text = "52", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Seguidores")
                }
            }
            Row()
            {
                //Aquí van los botones que contendrán la opción de editar perfil, seguir el perfil y compartir el perfil
                //Además, el boton indica la acción realizada en el logcat
                Column() {
                    Button(
                        modifier = Modifier
                            .padding(10.dp),
                        onClick =
                        {
                            println("Editar el perfil de entrenadora pokemon")
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6600)),
                        shape = RectangleShape
                    ) {
                        Text(
                            text = "Editar Perfil",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Column() {
                    Button(
                        modifier = Modifier
                            .padding(10.dp),
                        onClick =
                        {
                            println("Acabas de compartir el perfil de entrenadora pokemon")
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6600)),
                        shape = RectangleShape
                    ) {
                        Text(text = "Compartir Perfil", fontWeight = FontWeight.Bold)
                    }
                }
                Column() {
                    Button(
                        modifier = Modifier
                            .padding(10.dp),
                        onClick =
                        {
                            println("Acabas de seguir a entrenadora pokemon")
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6600)),
                        shape = RectangleShape
                    ) {
                        //Se usa la función if en color para que el svg cambie según el tema
                        Image(
                            painter = painterResource(id = R.drawable.ic_usuario),
                            contentDescription = "usuario",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(25.dp),
                            colorFilter = ColorFilter.tint(
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        )
                    }
                }
            }
            Row()
            {
                //categoría que contiene las historias de la cuenta
                Column() {
                    Text(text = "Historias Destacadas", fontWeight = FontWeight.Bold)
                    Text(text = "Guarda tus historias favoritas en el perfil")
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_mas),
                            contentDescription = "mas",
                            modifier = Modifier
                                .size(80.dp)
                                .padding(5.dp),
                            alignment = Alignment.Center,
                            colorFilter = ColorFilter.tint(
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        )
                        Text(text = "Nueva")
                    }

                }
            }
            Row(
            )
            {
                //Se comenta ya que los estudiantes Correa y Urquizo realizaron la implementación del For
                //El estudiante Castillo realizó el mismo resultado usando la parte comentada, donde se resuelve con un LazyVerticalGrid

                /*
                //Aquí van las imágenes
                //Se usa la lista creada arriba para que el LazyVerticalGrid pueda generar la tabla
                //La información de uso se encuentra en el siguiente url
                //https://foso.github.io/Jetpack-Compose-Playground/foundation/lazyverticalgrid/
                LazyVerticalGrid(columns = GridCells.Fixed(3), content =
                {
                    items(list.size) { index ->
                        Card() {
                            Image(
                                painter = rememberImagePainter(data = list[index]),
                                contentDescription = "pokemon",
                                modifier = Modifier.size(130.dp)
                            )
                        }
                    }
                }
                )
            */

                Column(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    // Ciclo que agregará Row de acuerdo a la cantidad de items

                    //Itera desde 0 hasta el tamaño del array dividido en 3 ya que son máx 3 items
                    //por cada fila
                    for (i in 0..sayayines.size / 3) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            //Se verifica si la posición existe en los indices existentes del array
                            //Esto para asegurarse que funcione si solo existen 1 o 2 imágenes en un Row
                            if ((i + 1) * 3 - 3 in sayayines.indices) {
                                Image(
                                    painter = rememberImagePainter(data = sayayines[(i + 1) * 3 - 3].imageUrl),
                                    contentDescription = "Foto del sayayin",
                                    modifier = Modifier.size(120.dp)
                                )
                            }
                            //Se verifica si la posición existe en los indices existentes del array

                            if ((i + 1) * 3 - 2 in sayayines.indices) {
                                Image(
                                    painter = rememberImagePainter(data = sayayines[(i + 1) * 3 - 2].imageUrl),
                                    contentDescription = "Foto del sayayin",
                                    modifier = Modifier.size(120.dp)
                                )
                            }
                            //Se verifica si la posición existe en los indices existentes del array
                            if ((i + 1) * 3 - 1 in sayayines.indices) {
                                Image(
                                    painter = rememberImagePainter(data = sayayines[(i + 1) * 3 - 1].imageUrl),
                                    contentDescription = "Foto del sayayin",
                                    modifier = Modifier.size(120.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}