package com.example.meucarrinho.ui.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meucarrinho.ui.theme.GreenPrimary
import com.example.meucarrinho.ui.theme.MeuCarrinhoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Novo Item", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector        = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Surface(
                            shape = CircleShape,
                            color = GreenPrimary,
                        ) {
                            Icon(
                                imageVector        = Icons.Default.Check,
                                contentDescription = "Confirmar",
                                tint               = Color.White,
                                modifier           = Modifier.padding(6.dp),
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
    ) { paddingValues ->
        Spacer(Modifier.height(8.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddItemScreenPreview() {
    MeuCarrinhoTheme {
        AddItemScreen()
    }
}