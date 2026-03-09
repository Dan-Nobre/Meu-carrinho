package com.example.meucarrinho.ui.screens

import android.R.attr.category
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meucarrinho.data.Category
import com.example.meucarrinho.data.ShoppingItem
import com.example.meucarrinho.ui.theme.BorderGray
import com.example.meucarrinho.ui.theme.GreenPrimary
import com.example.meucarrinho.ui.theme.MeuCarrinhoTheme
import com.example.meucarrinho.ui.theme.ProgressBackground
import com.example.meucarrinho.ui.theme.ProgressOrange
import kotlin.text.category

val sampleItems = listOf(
    ShoppingItem(name = "Bananas", category = Category.HORTALICAS, quantity = 6, isChecked = true),
    ShoppingItem(name = "Alface", category = Category.HORTALICAS, quantity = 2),
    ShoppingItem(name = "Bandeja de Ovos", category = Category.LATICINIOS, quantity = 3, isChecked = true),
    ShoppingItem(name = "Yogurte", category = Category.LATICINIOS, quantity = 1),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(items: List<ShoppingItem> = sampleItems,) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Meu Carrinho", fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = CircleShape,
                containerColor = GreenPrimary,
                contentColor = Color.White,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar item",
                )
            }
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
        ) {
            item {
                ProgressCard(items = items)
            }

            val grouped = items.groupBy { it.category }

            items(
                items = grouped.entries.toList(),
                key   = { it.key.name },
            ) { (category, categoryItems) ->
                CategoryCard(
                    category = category,
                    items    = categoryItems,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MeuCarrinhoTheme {
        HomeScreen()
    }
}

@Composable
fun ProgressCard(items: List<ShoppingItem>) {

    val checked = items.count { it.isChecked }
    val total = items.size
    val progress = if (total == 0) 0f else checked.toFloat() / total

    val message = when {
        progress == 0f -> "Vamos começar!"
        progress < 0.5f -> "Indo bem!"
        progress < 1f -> "Quase lá ein!"
        else -> "Tudo pronto!"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = ProgressBackground),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text       = "Progresso do Carrinho",
                fontSize   = 12.sp,
                color      = ProgressOrange,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(Modifier.height(4.dp))

            Row(
                modifier              = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment     = Alignment.CenterVertically,
            ) {
                Text(text = message, fontWeight = FontWeight.Bold)

                // Pílula branca com o contador
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White,
                ) {
                    Text(
                        text     = "$checked/$total",
                        fontSize = 12.sp,
                        color    = ProgressOrange,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(99.dp))
                    .background(BorderGray)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(99.dp))
                        .background(GreenPrimary)
                )
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: Category,
    items: List<ShoppingItem>,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = category.secondary),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Surface(
                    shape = CircleShape,
                    color = category.primary,
                    modifier = Modifier.size(36.dp),
                ) {
                    Icon(
                        imageVector = category.icon,
                        contentDescription = category.label,
                        tint = Color.White,
                        modifier = Modifier.padding(8.dp),
                    )
                }
                Text(
                    text = category.label,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            items.forEach { item ->
                ItemRow(
                    item          = item,
                    categoryColor = category.primary,
                )
            }
        }
    }
}


@Composable
fun ItemRow(
    item: ShoppingItem,
    categoryColor: Color,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = null, // sem interação por enquanto
                colors = CheckboxDefaults.colors(
                    checkedColor = categoryColor,
                    uncheckedColor = categoryColor,
                ),
            )
            Text(
                text = "${item.quantity}x ${item.name}",
                color = if (item.isChecked) Color.Gray else Color.Black,
                textDecoration = if (item.isChecked)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None,
            )
        }
    }
}
