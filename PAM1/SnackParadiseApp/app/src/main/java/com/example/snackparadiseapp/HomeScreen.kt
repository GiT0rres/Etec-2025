package com.example.snackparadiseapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snackparadiseapp.R

// Paleta de cores delicadas
private val LavenderLight = Color(0xFFE6E6FA)
private val PeriwinkleLight = Color(0xFFCCCCFF)
private val PastelBlue = Color(0xFFADD8E6)

@Composable
fun HomeScreen(
    userName: String = "Usuário",
    onCadastrarProduto: () -> Unit,
    onListarProdutos: () -> Unit,
    onLogout: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }

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
            .background(brush = gradient)
    ) {
        // Menu superior
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box {
                IconButton(
                    onClick = { menuExpanded = true },
                    modifier = Modifier
                        .background(
                            color = Color.White.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu",
                        tint = Color(0xFF6B5B95)
                    )
                }

                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },
                    modifier = Modifier.background(
                        Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                ) {
                    DropdownMenuItem(
                        text = { 
                            Text(
                                "Cadastrar Produto",
                                color = Color(0xFF6B5B95),
                                fontWeight = FontWeight.Medium
                            ) 
                        },
                        onClick = {
                            menuExpanded = false
                            onCadastrarProduto()
                        }
                    )
                    DropdownMenuItem(
                        text = { 
                            Text(
                                "Listar Produtos",
                                color = Color(0xFF6B5B95),
                                fontWeight = FontWeight.Medium
                            ) 
                        },
                        onClick = {
                            menuExpanded = false
                            onListarProdutos()
                        }
                    )
                    HorizontalDivider(color = Color(0xFFE6E6FA))
                    DropdownMenuItem(
                        text = { 
                            Text(
                                "Sair",
                                color = Color(0xFF9D8CBF),
                                fontWeight = FontWeight.Medium
                            ) 
                        },
                        onClick = {
                            menuExpanded = false
                            onLogout()
                        }
                    )
                }
            }
        }

        // Card central
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
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
                    modifier = Modifier.padding(40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(120.dp)
                            .padding(bottom = 24.dp)
                    )

                    Text(
                        text = "Olá, $userName!",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6B5B95),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Seja bem-vindo ao sistema de gerenciamento de produtos",
                        fontSize = 15.sp,
                        color = Color(0xFF9D8CBF),
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE6E6FA).copy(alpha = 0.3f)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Use o menu no canto superior direito para acessar as funcionalidades",
                            fontSize = 13.sp,
                            color = Color(0xFF6B5B95),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp),
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }
    }
}