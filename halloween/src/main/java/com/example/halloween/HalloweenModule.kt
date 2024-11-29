package com.example.halloween

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.ContentModule

class HalloweenModule : ContentModule {
    override val name = "Halloween"

    @Composable
    override fun LazyRowContent() {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            items(25) {
                Image(
                    painter = painterResource(android.R.drawable.ic_menu_gallery),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(150.dp)
                )
            }
        }
    }

    @Composable
    override fun ShowDialog(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text("OK")
                }
            },
            text = { Text("Ура! Ура!") }
        )
    }

    @Composable
    override fun LazyColumnContent() {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(25) { index ->
                Text(
                    text = "Halloweens item $index",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}