package com.example.meucarrinho.viewModel

import android.R.attr.category
import android.R.attr.name
import androidx.lifecycle.ViewModel
import com.example.meucarrinho.data.Category
import com.example.meucarrinho.data.ShoppingItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<ShoppingItem>>(emptyList())

    val items: StateFlow<List<ShoppingItem>> = _items.asStateFlow()

    fun addItem(name: String, category: Category, quantity: Int) {
        if (name.isBlank()) return
        _items.update { current ->
            current + ShoppingItem(
                name     = name.trim(),
                category = category,
                quantity = quantity,
            )
        }
    }

    fun toggleItem(id: Long) {
        _items.update { current ->
            current.map { item ->
                if (item.id == id) item.copy(isChecked = !item.isChecked)
                else item
            }
        }
    }
}
