package com.example.snackparadiseapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Paleta de cores delicadas
private val LavenderLight = Color(0xFFE6E6FA)
private val PeriwinkleLight = Color(0xFFCCCCFF)
private val PastelBlue = Color(0xFFADD8E6)

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarProdutosScreen(onBack: () -> Unit) {
    val produtos = remember {
        mutableStateListOf(
            Produto("Notebook Gamer", 5, "RTX 4090, 32GB RAM"),
            Produto("Smartphone", 15, "Tela AMOLED 6.5\""),
            Produto("Fone Bluetooth", 30, "Noise Cancelling")
        )
    }

    var produtoEmEdicao by remember { mutableStateOf<Produto?>(null) }
    var nome by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            PeriwinkleLight,
            LavenderLight,
            PastelBlue
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Meus Produtos",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6B5B95)
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.Filled.ArrowBack, 
                            contentDescription = "Voltar",
                            tint = Color(0xFF6B5B95)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White.copy(alpha = 0.9f)
                )
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = innerPadding.calculateTopPadding() + 8.dp,
                    bottom = innerPadding.calculateBottomPadding() + 8.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(produtos, key = { it.nome }) { produto ->
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.95f)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        color = Color(0xFFE6E6FA).copy(alpha = 0.5f),
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ShoppingCart,
                                    contentDescription = null,
                                    tint = Color(0xFF9D8CBF),
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                            
                            Spacer(modifier = Modifier.width(16.dp))
                            
                            Column(Modifier.weight(1f)) {
                                Text(
                                    text = produto.nome,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF6B5B95)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Quantidade: ${produto.quantidade}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(0xFF9D8CBF),
                                    fontWeight = FontWeight.Medium
                                )
                                if (produto.descricao.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = produto.descricao,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color(0xFF9D8CBF).copy(alpha = 0.8f)
                                    )
                                }
                            }
                            
                            IconButton(
                                onClick = {
                                    produtoEmEdicao = produto
                                    nome = produto.nome
                                    quantidade = produto.quantidade.toString()
                                    descricao = produto.descricao
                                },
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFCCCCFF).copy(alpha = 0.3f),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                Icon(
                                    Icons.Filled.Edit, 
                                    contentDescription = "Editar",
                                    tint = Color(0xFF9D8CBF)
                                )
                            }
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            IconButton(
                                onClick = { produtos.remove(produto) },
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFFFCDD2).copy(alpha = 0.3f),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                Icon(
                                    Icons.Filled.Delete, 
                                    contentDescription = "Excluir",
                                    tint = Color(0xFFD32F2F)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (produtoEmEdicao != null) {
        AlertDialog(
            onDismissRequest = { produtoEmEdicao = null },
            title = { 
                Text(
                    "Editar Produto",
                    color = Color(0xFF6B5B95),
                    fontWeight = FontWeight.Bold
                ) 
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = nome,
                        onValueChange = { nome = it },
                        label = { Text("Produto", color = Color(0xFF8B7BA8)) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF9D8CBF),
                            unfocusedBorderColor = Color(0xFFD8BFD8),
                            focusedLabelColor = Color(0xFF6B5B95),
                            cursorColor = Color(0xFF9D8CBF)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = quantidade,
                        onValueChange = { quantidade = it },
                        label = { Text("Quantidade", color = Color(0xFF8B7BA8)) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF9D8CBF),
                            unfocusedBorderColor = Color(0xFFD8BFD8),
                            focusedLabelColor = Color(0xFF6B5B95),
                            cursorColor = Color(0xFF9D8CBF)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = descricao,
                        onValueChange = { descricao = it },
                        label = { Text("Descrição", color = Color(0xFF8B7BA8)) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF9D8CBF),
                            unfocusedBorderColor = Color(0xFFD8BFD8),
                            focusedLabelColor = Color(0xFF6B5B95),
                            cursorColor = Color(0xFF9D8CBF)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val index = produtos.indexOf(produtoEmEdicao)
                        if (index >= 0) {
                            produtos[index] = Produto(
                                nome,
                                quantidade.toIntOrNull() ?: 0,
                                descricao
                            )
                        }
                        produtoEmEdicao = null
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9D8CBF)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Salvar", fontWeight = FontWeight.SemiBold)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { produtoEmEdicao = null },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Color(0xFF9D8CBF)
                    )
                ) { 
                    Text("Cancelar", fontWeight = FontWeight.Medium)
                }
            },
            containerColor = Color.White,
            shape = RoundedCornerShape(24.dp)
        )
    }
}

data class Produto(
    val nome: String,
    val quantidade: Int,
    val descricao: String
)