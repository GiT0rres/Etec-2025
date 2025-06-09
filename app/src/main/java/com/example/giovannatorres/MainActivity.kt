package com.example.giovannatorres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giovannatorres.ui.theme.GiovannaTorresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GiovannaTorresTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                AppLoginPreview()
                }
            }
        }
    }
}

@Composable
fun AppLogin(){

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val gradiente = Brush.verticalGradient(
        colors = listOf(Color.Magenta, Color.White)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush=gradiente),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp)   ,
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kity),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(80.dp)
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = "App Login",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                 modifier = Modifier, color = Color.Magenta
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = user,
                    onValueChange = {user = it },
                    label = { Text("Usuário")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it },
                    label = {Text("Senha")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Magenta
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                {
                    Text("Logar", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(12.dp))

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        "Esqueceu a Senha?",
                        color = Color.Magenta,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
@Composable
fun TelaRegistro(){

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    val gradiente = Brush.verticalGradient(
        colors = listOf(Color.Blue, Color.White)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush=gradiente),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp)  ,
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kity2),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(80.dp)
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = "App Login",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome de Usuário") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    label = { Text("Confirme sua senha") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                {
                    Text("Cadastrar", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(12.dp))

                TextButton(
                    onClick = {}
                ) {
                    Text(
                        "Já tem uma conta? Entre com a gente.",
                        color = Color.Blue,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
@Composable
fun HomeScreen(userName: String = "Usuário"){
    var menuExpandido by remember { mutableStateOf(false) }
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color.Red, Color.White)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Box{
                IconButton(onClick = {menuExpandido = true}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                DropdownMenu(
                    expanded = menuExpandido,
                    onDismissRequest = {menuExpandido = false}
                ) {
                    DropdownMenuItem(
                        text = {Text("Cadastrar Produto")},
                        onClick = {
                            menuExpandido = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Listar Produto")},
                        onClick = {
                            menuExpandido = false
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Perfil de $userName")},
                        onClick = {
                            menuExpandido = false
                        }
                    )
                    Divider()
                    DropdownMenuItem(
                        text = {Text("Deslogar")},
                        onClick = {
                            menuExpandido = false
                        }
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .padding(top = 80.dp, bottom = 40.dp)
                .fillMaxWidth(0.9f)
                .fillMaxSize(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.kity3),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(130.dp)
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = "Bem-vindo, $userName!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Use o menu no canto superior direito para navegar",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
@Preview
@Composable
fun AppLoginPreview(){
    AppLogin()
}
@Preview
@Composable
fun TelaRegistroPreview(){
    TelaRegistro()
}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
