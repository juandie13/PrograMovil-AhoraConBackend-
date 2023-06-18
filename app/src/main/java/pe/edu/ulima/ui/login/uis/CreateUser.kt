package pe.edu.ulima.ui.login.uis

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.edu.ulima.R
import pe.edu.ulima.ui.login.viewmodels.CreateUserViewModel
import pe.edu.ulima.ui.theme.Gray200
import pe.edu.ulima.ui.theme.Gray400
import pe.edu.ulima.ui.theme.Orange200

@Composable
public fun CreateUser(
    viewModel: CreateUserViewModel,
    navController: NavController,
    goToLoginScreen: () -> Unit
){
    val context = LocalContext.current as Activity
    // viewmodel
    val usuario : String by viewModel.usuario.observeAsState(initial = "")
    val contrasenia : String by viewModel.contrasenia.observeAsState(initial = "")
    val repContrasenia : String by viewModel.repContrasenia.observeAsState(initial = "")
    val correo : String by viewModel.correo.observeAsState(initial = "")
    val mensaje : String by viewModel.mensaje.observeAsState(initial = "")
    // close
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = {
                Log.d("LOGIN_SCREEN", "XDDDDDDDDDDDDDDDDDDD")
                context.finish()
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Person Icon",
            )
        }
    }
    // container
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_otg),
                contentDescription = "Logo OTG",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 10.dp),
                colorFilter = ColorFilter.tint(

                    color = if (isSystemInDarkTheme()) Orange200 else Gray200
                )
            )
            Text(
                text = "Crear Cuenta",
                textAlign = TextAlign.Center,
            )
            if (mensaje.contains("Error")) {
                Text(
                    text = mensaje.split(":")[1],
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            } else {
                Text(
                    text = mensaje,
                    textAlign = TextAlign.Center,
                    color = Color.Green
                )
            }
            // txtCorreo
            TextField(
                value = usuario,
                onValueChange = {
                    viewModel.updateUsuario(it)
                },
                modifier = Modifier.fillMaxWidth(),
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
                modifier = Modifier.fillMaxWidth(),
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

            TextField(
                value = contrasenia,
                onValueChange = {
                    viewModel.updateContrasenia(it)
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Contraseña")
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
                value = repContrasenia,
                onValueChange = {
                    viewModel.updateRepContrasenia(it)
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Repetir Contraseña")
                },
                placeholder = {
                    Text(text = "")
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            // boton reset
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {
                    viewModel.reset()
                }
            ) {
                Text("CREAR")
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp,
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {
                    goToLoginScreen()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Gray400)
            ) {
                Text("INGRESAR AL SISTEMA".toUpperCase())
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp/*, start = 40.dp, end = 40.dp*/), // start -> izquierda, end -> derecha
                onClick = {
                    navController.navigate("/reset_password")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Gray400)
            ) {
                Text("RECUPERAR CONTRASEÑA".toUpperCase())
            }
        }
    }
}