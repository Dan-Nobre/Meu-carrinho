package com.example.meucarrinho.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meucarrinho.data.Category
import com.example.meucarrinho.ui.theme.MeuCarrinhoTheme

@Preview(showBackground = true)
@Composable
fun CategoryIconsPreview() {
    MeuCarrinhoTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Category.entries.forEach { category ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(category.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector        = category.icon,
                            contentDescription = category.label,
                            tint               = Color.White,
                            modifier           = Modifier.size(24.dp)
                        )
                    }
                    Text(
                        text     = category.label.split(" ").first(),
                        fontSize = 10.sp,
                        color    = category.primary
                    )
                }
            }
        }
    }
}