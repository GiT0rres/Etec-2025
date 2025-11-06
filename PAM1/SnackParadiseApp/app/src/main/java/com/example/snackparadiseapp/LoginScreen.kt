package com.example.snackparadiseapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snackparadiseapp.R

// Paleta de cores delicadas
private val LavenderLight = Color(0xFFE6E6FA)
private val LavenderMedium = Color(0xFFD8BFD8)
private val PeriwinkleLight = Color(0xFFCCCCFF)
private val SoftBlue = Color(0xFFB0C4DE)
private val LightPurple = Color(0xFFDDA0DD)
private val PastelBlue = Color(0xFFADD8E6)

@Composable
fun LoginScreen(onLogin: (String) -> Unit, onRegisterClick: () -> Unit) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dbHelper = remember { UserDatabaseHelper(context) }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            PeriwinkleLight,
            LavenderLight,
            PastelBlue
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(32.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(100.dp)
                        .padding(bottom = 20.dp)
                )

                Text(
                    text = "Bem-vindo de volta",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6B5B95)
                )

                Text(
                    text = "Entre na sua conta",
                    fontSize = 14.sp,
                    color = Color(0xFF9D8CBF),
                    modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
                )

                OutlinedTextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text("Usuário", color = Color(0xFF8B7BA8)) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Person, 
                            contentDescription = null,
                            tint = Color(0xFF9D8CBF)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF9D8CBF),
                        unfocusedBorderColor = Color(0xFFD8BFD8),
                        focusedLabelColor = Color(0xFF6B5B95),
                        cursorColor = Color(0xFF9D8CBF)
                    ),
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha", color = Color(0xFF8B7BA8)) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Lock, 
                            contentDescription = null,
                            tint = Color(0xFF9D8CBF)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF9D8CBF),
                        unfocusedBorderColor = Color(0xFFD8BFD8),
                        focusedLabelColor = Color(0xFF6B5B95),
                        cursorColor = Color(0xFF9D8CBF)
                    ),
                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {
                        if (dbHelper.authenticate(user, password)) {
                            onLogin(user)
                        } else {
                            Toast.makeText(
                                context,
                                "Usuário ou senha inválidos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9D8CBF)
                    )
                ) {
                    Text("Entrar", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = { onRegisterClick() }) {
                    Text(
                        "Esqueceu a senha?",
                        color = Color(0xFF8B7BA8),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}