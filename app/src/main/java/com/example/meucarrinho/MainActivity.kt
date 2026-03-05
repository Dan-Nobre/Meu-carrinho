package com.example.meucarrinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meucarrinho.data.Category
import com.example.meucarrinho.data.ShoppingItem
import com.example.meucarrinho.ui.theme.MeuCarrinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuCarrinhoTheme {
                val item = ShoppingItem(
                    name = "Bananas",
                    category = Category.HORTALICAS,
                    quantity = 6
                )
                println("Item criado: ${item.name} | Categoria: ${item.category.label}")
            }
        }
    }
}