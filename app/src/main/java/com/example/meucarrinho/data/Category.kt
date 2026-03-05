package com.example.meucarrinho.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Cookie
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.meucarrinho.ui.theme.BluePrimary
import com.example.meucarrinho.ui.theme.BlueSecondary
import com.example.meucarrinho.ui.theme.BrownPrimary
import com.example.meucarrinho.ui.theme.BrownSecondary
import com.example.meucarrinho.ui.theme.GreenPrimary
import com.example.meucarrinho.ui.theme.GreenSecondary
import com.example.meucarrinho.ui.theme.OrangePrimary
import com.example.meucarrinho.ui.theme.OrangeSecondary
import com.example.meucarrinho.ui.theme.PurplePrimary
import com.example.meucarrinho.ui.theme.PurpleSecondary
import com.example.meucarrinho.ui.theme.RedPrimary
import com.example.meucarrinho.ui.theme.RedSecondary

enum class Category(
    val label    : String,
    val icon     : ImageVector,
    val primary  : Color,
    val secondary: Color,
) {
    HORTALICAS(
        label     = "Hortaliças",
        icon      = Icons.Default.Eco,
        primary   = GreenPrimary,
        secondary = GreenSecondary,
    ),
    LATICINIOS(
        label     = "Laticínios e Ovos",
        icon      = Icons.Default.Egg,
        primary   = OrangePrimary,
        secondary = OrangeSecondary,
    ),
    LIMPEZA(
        label     = "Itens de Limpeza",
        icon      = Icons.Default.LocalLaundryService,
        primary   = BluePrimary,
        secondary = BlueSecondary,
    ),
    PADARIA(
        label     = "Padaria",
        icon      = Icons.Default.BakeryDining,
        primary   = BrownPrimary,
        secondary = BrownSecondary,
    ),
    PROTEINAS(
        label     = "Proteínas",
        icon      = Icons.Default.SetMeal,
        primary   = RedPrimary,
        secondary = RedSecondary,
    ),
    LANCHES(
        label     = "Lanches",
        icon      = Icons.Default.Cookie,
        primary   = PurplePrimary,
        secondary = PurpleSecondary,
    ),
}