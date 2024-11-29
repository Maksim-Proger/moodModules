package com.example.core

interface ContentModule {
    val name: String

    @androidx.compose.runtime.Composable
    fun LazyRowContent()

    @androidx.compose.runtime.Composable
    fun ShowDialog(onDismiss: () -> Unit)

    @androidx.compose.runtime.Composable
    fun LazyColumnContent()
}
