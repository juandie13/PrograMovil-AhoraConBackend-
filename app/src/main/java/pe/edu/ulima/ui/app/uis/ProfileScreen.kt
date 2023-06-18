package pe.edu.ulima.ui.app.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel
import pe.edu.ulima.ui.app.viewmodels.ProfileViewModel


@Preview
@Composable
public fun ProfileScreenPreview(){
    PokemonScreen(
        PokemonViewModel(),
        rememberNavController(),
        0
    )
}
@ExperimentalMaterialApi
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {

    val nombre: String by viewModel.nombre.observeAsState("")
    val url: String by viewModel.imagen.observeAsState("")
    val correo: String by viewModel.correo.observeAsState("")
    val usuario: String by viewModel.usuario.observeAsState("")
    val contrasenia: String by viewModel.contrasenia.observeAsState("")
    val newContrasenia: String by viewModel.newContrasenia.observeAsState("")
    val repeatContrasenia: String by viewModel.repeatContrasenia.observeAsState("")

    val mensaje: String by viewModel.mensaje.observeAsState("")

    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true,
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Editar Perfil",
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp
            )
            // Imagen centrada verticalmente del perfil
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = rememberImagePainter(data = url),
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(bottom = 10.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    TextField(
                        value = nombre,
                        onValueChange = {
                            viewModel.updateNombre(it)
                        },
                        enabled = viewModel.camposHabilitados,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        label = {
                            Text(text = "Nombre")
                        },
                        placeholder = {
                            Text(text = "")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent
                        )
                    )
                    TextField(
                        value = usuario,
                        onValueChange = {
                            viewModel.updateUsuario(it)
                        },
                        enabled = viewModel.camposHabilitados,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        label = {
                            Text(text = "Usuario")
                        },
                        placeholder = {
                            Text(text = "")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent
                        )
                    )
                    TextField(
                        value = correo,
                        onValueChange = {
                            viewModel.updateCorreo(it)
                        },
                        enabled = viewModel.camposHabilitados,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp, start = 30.dp, end = 30.dp),
                        label = {
                            Text(text = "Correo")
                        },
                        placeholder = {
                            Text(text = "")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent
                        )
                    )
                    if(mensaje.contains("Error")){
                        Text(
                            text = mensaje.split(":")[1],
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                    }else{
                        Text(
                            text = mensaje,
                            textAlign = TextAlign.Center,
                            color = Color.Green
                        )
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                        onClick = {
                            // Acción para actualizar los datos
                            viewModel.updateData()
                        }
                    ) {
                        Text(
                            text = "ACTUALIZAR DATOS",
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    ModalBottomSheetLayout(
                        sheetState = modalSheetState,
                        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                        sheetContent = {
                            Column(
                                //Centrar elementos en la columna
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Row(
                                    //Gives padding to the row
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp),
                                ) {
                                    Text(
                                        text = "Cambiar Contraseña",
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                                Row(
                                    //Gives padding to the row
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp),
                                ){
                                    TextField(
                                        value = contrasenia,
                                        onValueChange = {
                                            viewModel.updateContrasenia(it)
                                        },
                                        label = {
                                            Text(text = "Contraseña")
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        placeholder = {
                                            Text(text= "")
                                        },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            backgroundColor = Color.Transparent
                                        ),
                                        visualTransformation = PasswordVisualTransformation(),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                                    )
                                }
                                Row(
                                    //Gives padding to the row
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp),
                                ) {
                                    TextField(
                                        value = newContrasenia,
                                        onValueChange = {
                                            viewModel.updateNewContrasenia(it)
                                        },
                                        label = {
                                            Text(text = "Nueva Contraseña")
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        placeholder = {
                                            Text(text= "")
                                        },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            backgroundColor = Color.Transparent
                                        ),
                                        visualTransformation = PasswordVisualTransformation(),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                                    )
                                }
                                Row(
                                    //Gives padding to the row
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp),
                                ){
                                    TextField(
                                        value = repeatContrasenia,
                                        onValueChange = {
                                            viewModel.updateRepeatContrasenia(it)
                                        },
                                        label = {
                                            Text(text = "Repetir Contraseña Nueva")
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        placeholder = {
                                            Text(text= "")
                                        },
                                        singleLine = true,
                                        colors = TextFieldDefaults.textFieldColors(
                                            backgroundColor = Color.Transparent
                                        ),
                                        visualTransformation = PasswordVisualTransformation(),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                                    )
                                }
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                                    onClick = {
                                        // Acción para actualizar la contraseña
                                        viewModel.validatePassword()
                                        coroutineScope.launch { modalSheetState.hide() }
                                    }
                                ) {
                                    Text(
                                        text = "ACTUALIZAR CONTRASEÑA",
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                            }
                        }
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp, start = 30.dp, end = 30.dp),
                            onClick = {
                                // Acción para cambiar la contraseña
                                coroutineScope.launch {
                                    if (modalSheetState.isVisible)
                                        modalSheetState.hide()
                                    else
                                        modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                                }
                            }
                        ) {
                            Text(
                                text = "CAMBIAR CONTRASEÑA",
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }
            }
        }
    }
}