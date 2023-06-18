package pe.edu.ulima.ui.app.uis
import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import pe.edu.ulima.activities.ui.theme.Teal200
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel
import pe.edu.ulima.ui.theme.Orange200
import pe.edu.ulima.ui.theme.TopBar

@Preview
@Composable
public fun PokemonScreenPreview(){
    PokemonScreen(
        PokemonViewModel(),
        rememberNavController(),
        0,
    )
}

val LocalActivity = compositionLocalOf<ComponentActivity> { error("No Activity found") }

@OptIn(ExperimentalMaterialApi::class)
@Composable
public fun PokemonScreen(
    viewModel: PokemonViewModel,
    navController: NavHostController,
    profileId: Int,
) {
    val context = LocalContext.current
    val activity = context as Activity
    val intent = activity.intent
    Log.d("POKEMON_SCREEN", intent.getIntExtra("user_id", 0).toString())

    var userId = 0
    if (profileId == 0) {
        userId = intent.getIntExtra("user_id", 0)
    } else {
        userId = profileId
    }
    val seguidores: Int by viewModel.seguidores.observeAsState(0)
    val seguidos: Int by viewModel.seguidos.observeAsState(0)
    viewModel.setPokemons()
    //viewModel.setImagenes(userId)
    viewModel.setSeguidores(userId)
    viewModel.setSeguidos(userId)
    var isBottomSheetOpen by rememberSaveable { mutableStateOf(false) }

    ModalBottomSheetLayout(
        sheetState = ModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden
        ),
        sheetContent = {
            // Contenido de Modal BottomSheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            ) {
                Text("Contenido de Modal BottomSheet")
                // isBottomSheetOpen = true
            }
        }
    ) {
        Column {
            TopBar(
                showBottomSheetDialog = {
                    isBottomSheetOpen = true
                },
                navController,
                userId
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Agrega la foto de perfil de Goku
                    Image(
                        painter = rememberImagePainter(data = viewModel.getImagenById(userId)),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )

                    Spacer(Modifier.width(10.dp))

                    Column {

                        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                            Text(
                                text = seguidores.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                                modifier = Modifier.clickable {
                                    Log.d("POKEMON_SCREEN", "SEGUIDORES CLICK")
                                    navController.navigate("/seguidores?user_id=$userId")
                                }
                            )
                        }
                        Text(
                            "Seguidores",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            modifier = Modifier.clickable {
                                Log.d("POKEMON_SCREEN", "SEGUIDORES CLICK")
                                navController.navigate("/seguidores?user_id=$userId")
                            }
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Column {
                        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                            Text(
                                text = seguidos.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                                modifier = Modifier.clickable {
                                    Log.d("POKEMON_SCREEN", "SEGUIDORES CLICK")
                                    navController.navigate("/seguidores?user_id=$userId")
                                }
                            )
                        }
                        Text(
                            text = "Seguidos",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            modifier = Modifier.clickable {
                                Log.d("POKEMON_SCREEN", "SEGUIDORES CLICK")
                                navController.navigate("/seguidores?user_id=$userId")
                            }
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Column {
                        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                            Text(
                                text = viewModel.imagenes!!.size.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                                modifier = Modifier.graphicsLayer {
                                }
                            )
                        }
                        Text(
                            text = "Publicaciones",
                            fontSize = 16.sp,
                            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                            modifier = Modifier.graphicsLayer {

                            }
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = viewModel.getNameById(userId),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = (if(isSystemInDarkTheme()) Orange200 else Teal200),
                )

            }

            Spacer(Modifier.height(16.dp))

            Row( modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {

                Button(
                    modifier = Modifier
                        .padding(start = 30.dp, end = 10.dp),
                    onClick = {
                        navController.navigate("/profile/?user_id=$userId")},
                    colors = ButtonDefaults.buttonColors(backgroundColor = (if (isSystemInDarkTheme()) Teal200 else Orange200))
                ) {
                    Text("Editar perfil", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
                }

                Button(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = (if (isSystemInDarkTheme()) Teal200 else Orange200))
                ) {
                    Text("Compartir perfil", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
                }
            }

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(5),
                    content = {
                        items(viewModel.imagenes!!.size) { i ->
                            val imagen: Imagen = viewModel.imagenes!![i]
                            Image(
                                painter = rememberImagePainter(data = imagen.url),
                                contentDescription = "XD",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(bottom = 10.dp)
                                    .clickable {
                                        //Log.d("POKEMON_SCREEN", pokemon.id.toString())
                                        //navController.navigate("/pokemon/detalle?pokemon_id=${pokemon.id.toString()}")
                                    },
                            )
                        }
                    }
                )
            }
        }

    Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = {
                    navController.navigate("/pokemon/new")
                },
                content = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null
                    )
                },
                backgroundColor = Orange200,
                modifier = Modifier.padding(20.dp)
            )
        }

        if (userId != 0) {
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            BackHandler {
                Log.d("POKEMON_SCREEN", "XDDDDDDDDDDDDDDDDDDDDDDDdd")
                finishAffinity(context as Activity)
            }
        }
    }

