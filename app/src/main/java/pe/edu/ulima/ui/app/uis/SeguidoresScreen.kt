package pe.edu.ulima.ui.app.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import pe.edu.ulima.models.Usuario
import pe.edu.ulima.ui.app.viewmodels.SeguidorViewModel

@Preview
@Composable
fun SeguidoresScreenPreview() {
    SeguidoresScreen(
        SeguidorViewModel(),
        rememberNavController(),
    )
}

@Composable
fun SeguidoresScreen(
    viewModel: SeguidorViewModel,
    navController: NavHostController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("", modifier = Modifier.padding(16.dp))
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(viewModel.usuarios!!) { usuario ->
                UsuarioItem(
                    usuario = usuario,
                    onItemClick = {
                        navController.navigate("/pokemon?user_id=${usuario.id}")
                    }
                )
                Divider()
            }
        }
    }
}

@Composable
fun UsuarioItem(usuario: Usuario, onItemClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = usuario.imagen),
            contentDescription = "User Image",
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(text = usuario.nombre)
            Text(text = usuario.usuario)
            Text(text = usuario.correo)
        }
    }
}