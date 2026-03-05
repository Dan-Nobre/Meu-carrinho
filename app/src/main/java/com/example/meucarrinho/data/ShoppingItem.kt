package com.example.meucarrinho.data

data class ShoppingItem(
    val id       : Long     = System.currentTimeMillis(),
    val name     : String,
    val category : Category,
    val quantity : Int      = 1,
    val isChecked: Boolean  = false
)