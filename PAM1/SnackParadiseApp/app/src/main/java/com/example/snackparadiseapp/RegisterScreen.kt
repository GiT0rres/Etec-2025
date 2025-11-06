package com.example.snackparadiseapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
private val PeriwinkleLight = Color(0xFFCCCCFF)
private val PastelBlue = Color(0xFFADD8E6)

@Composable
fun RegisterScreen(onRegisterComplete: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dbHelper = remember { UserDatabaseHelper(context) }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            PastelBlue,
            PeriwinkleLight,
            LavenderLight
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
                modifier = Modifier
                    .padding(32.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.drawable.asd),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(90.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "Criar Conta",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6B5B95)
                )

                Text(
                    text = "Preencha os dados abaixo",
                    fontSize = 14.sp,
                    color = Color(0xFF9D8CBF),
                    modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Nome de usuário", color = Color(0xFF8B7BA8)) },
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

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail", color = Color(0xFF8B7BA8)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Email, 
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

                Spacer(modifier = Modifier.height(14.dp))

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

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirmar senha", color = Color(0xFF8B7BA8)) },
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

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                        } else if (password != confirmPassword) {
                            Toast.makeText(context, "Senhas não coincidem!", Toast.LENGTH_SHORT).show()
                        } else {
                            val success = dbHelper.insertUser(username, email, password)
                            if (success) {
                                Toast.makeText(context, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                                onRegisterComplete()
                            } else {
                                Toast.makeText(context, "Erro: usuário já existe!", Toast.LENGTH_SHORT).show()
                            }
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
                    Text("Cadastrar", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = { onRegisterComplete() }) {
                    Text(
                        "Já tem uma conta? Faça login",
                        color = Color(0xFF8B7BA8),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}