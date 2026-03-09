package com.example.meucarrinho.ui.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meucarrinho.data.Category
import com.example.meucarrinho.ui.theme.GreenPrimary
import com.example.meucarrinho.ui.theme.MeuCarrinhoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen() {

    var itemName by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(Category.HORTALICAS) }
    var quantity by remember { mutableStateOf(1) }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {

            Column {
                Text(
                    text       = "Nome do Item",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value           = itemName,
                    onValueChange   = { itemName = it },
                    placeholder     = { Text("Suco de Laranja...") },
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    shape           = RoundedCornerShape(12.dp),
                )
            }

            Column {
                Text(
                    text       = "Selecione a Categoria",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(12.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding        = PaddingValues(horizontal = 4.dp),
                ) {
                    items(Category.entries) { category ->
                        CategoryOption(
                            category   = category,
                            isSelected = category == selectedCategory,
                            onClick    = { selectedCategory = category },
                        )
                    }
                }
            }

            Column {
                Text(
                    text       = "Qual a quantidade?",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(8.dp))
                QuantitySelector(
                    quantity         = quantity,
                    onQuantityChange = { quantity = it },
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddItemScreenPreview() {
    MeuCarrinhoTheme {
        AddItemScreen()
    }
}

@Composable
fun CategoryOption(
    category  : Category,
    isSelected: Boolean,
    onClick   : () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier            = Modifier
            .clickable { onClick() }
            .padding(vertical = 4.dp),
    ) {
        Surface(
            shape  = CircleShape,
            color  = if (isSelected) category.primary else category.secondary,
            border = if (isSelected)
                BorderStroke(2.dp, category.primary)
            else
                null,
            modifier = Modifier.size(52.dp),
        ) {
            Icon(
                imageVector        = category.icon,
                contentDescription = category.label,
                tint               = if (isSelected) Color.White else category.primary,
                modifier           = Modifier.padding(12.dp),
            )
        }

        Spacer(Modifier.height(4.dp))

        Text(
            text       = category.label.split(" ").first(),
            fontSize   = 10.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color      = if (isSelected) category.primary else Color.Gray,
        )
    }
}

@Composable
fun QuantitySelector(
    quantity        : Int,
    onQuantityChange: (Int) -> Unit,
) {
    Card(
        modifier  = Modifier.fillMaxWidth(),
        shape     = RoundedCornerShape(16.dp),
        colors    = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment     = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            FilledIconButton(
                onClick  = { if (quantity > 1) onQuantityChange(quantity - 1) },
                enabled  = quantity > 1,
                shape    = CircleShape,
                colors   = IconButtonDefaults.filledIconButtonColors(
                    containerColor         = Color.White,
                    contentColor           = Color(0xFF1A1A1A),
                    disabledContainerColor = Color(0xFFE0E0E0),
                    disabledContentColor   = Color.LightGray,
                ),
                modifier = Modifier.size(44.dp),
            ) {
                Icon(Icons.Default.Remove, contentDescription = "Diminuir")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text       = "$quantity",
                    fontSize   = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text     = "UND.",
                    fontSize = 12.sp,
                    color    = Color.Gray,
                )
            }

            FilledIconButton(
                onClick  = { onQuantityChange(quantity + 1) },
                shape    = CircleShape,
                colors   = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White,
                    contentColor   = Color(0xFF1A1A1A),
                ),
                modifier = Modifier.size(44.dp),
            ) {
                Icon(Icons.Default.Add, contentDescription = "Aumentar")
            }
        }
    }
}