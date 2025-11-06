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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snackparadiseapp.R

// Paleta de cores delicadas
private val LavenderLight = Color(0xFFE6E6FA)
private val PeriwinkleLight = Color(0xFFCCCCFF)
private val PastelBlue = Color(0xFFADD8E6)

@Composable
fun CadastrarProdutoScreen(onRegisterComplete: () -> Unit) {
    var produto by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    val context = LocalContext.current
    val dbHelper = remember {
        ProductDatabaseHelper.getInstance(context.applicationContext)
    }

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
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(90.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "Novo Produto",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6B5B95)
                )

                Text(
                    text = "Adicione um produto ao estoque",
                    fontSize = 14.sp,
                    color = Color(0xFF9D8CBF),
                    modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
                )

                OutlinedTextField(
                    value = produto,
                    onValueChange = { produto = it },
                    label = { Text("Nome do Produto", color = Color(0xFF8B7BA8)) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.ShoppingCart, 
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
                    value = quantidade,
                    onValueChange = { quantidade = it },
                    label = { Text("Quantidade", color = Color(0xFF8B7BA8)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.List, 
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
                    value = descricao,
                    onValueChange = { descricao = it },
                    label = { Text("Descrição", color = Color(0xFF8B7BA8)) },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Info, 
                            contentDescription = null,
                            tint = Color(0xFF9D8CBF)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    maxLines = 4,
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
                        val quantidadeInt = quantidade.toIntOrNull()

                        if (produto.isBlank()) {
                            Toast.makeText(
                                context,
                                "Informe o nome do produto",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@Button
                        }

                        if (quantidadeInt == null) {
                            Toast.makeText(
                                context,
                                "Informe uma quantidade válida",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@Button
                        }

                        val sucesso = dbHelper.insertProduct(
                            produto.trim(),
                            quantidadeInt,
                            descricao.trim()
                        )

                        if (sucesso) {
                            Toast.makeText(
                                context,
                                "Produto cadastrado com sucesso",
                                Toast.LENGTH_SHORT
                            ).show()
                            produto = ""
                            quantidade = ""
                            descricao = ""
                            onRegisterComplete()
                        } else {
                            Toast.makeText(
                                context,
                                "Erro ao cadastrar produto",
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
                    Text("Cadastrar Produto", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}