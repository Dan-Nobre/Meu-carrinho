package com.example.meucarrinho.data

import androidx.compose.ui.graphics.Color
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
    val primary  : Color,
    val secondary: Color,
) {
    HORTALICAS(
    label     = "Hortaliças",
    primary   = GreenPrimary,
    secondary = GreenSecondary,
    ),
    LATICINIOS(
    label     = "Laticínios e Ovos",
    primary   = OrangePrimary,
    secondary = OrangeSecondary,
    ),
    LIMPEZA(
    label     = "Itens de Limpeza",
    primary   = BluePrimary,
    secondary = BlueSecondary,
    ),
    PADARIA(
    label     = "Padaria",
    primary   = BrownPrimary,
    secondary = BrownSecondary,
    ),
    PROTEINAS(
    label     = "Proteínas",
    primary   = RedPrimary,
    secondary = RedSecondary,
    ),
    LANCHES(
    label     = "Lanches",
    primary   = PurplePrimary,
    secondary = PurpleSecondary,
    ),
}