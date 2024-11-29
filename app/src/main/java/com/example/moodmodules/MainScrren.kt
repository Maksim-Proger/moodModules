package com.example.moodmodules

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ContentModule

@Composable
fun MainScreen(moduleProvider: ModuleProvider) {
    var selectedModule by remember { mutableStateOf<ContentModule?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            // Кнопка для модуля "Christmas"
            moduleProvider.getModuleByName("Christmas")?.let { module ->
                Button(onClick = { selectedModule = module }) {
                    Text(module.name)
                }
            }

            // Кнопка для модуля "New Year"
            moduleProvider.getModuleByName("New Year")?.let { module ->
                Button(onClick = { selectedModule = module }) {
                    Text(module.name)
                }
            }

            // Кнопка для модуля "Halloween"
            moduleProvider.getModuleByName("Halloween")?.let { module ->
                Button(onClick = { selectedModule = module }) {
                    Text(module.name)
                }
            }
        }

        // Вывод LazyRowContent из выбранного модуля
        selectedModule?.LazyRowContent()

        // Вывод LazyColumnContent из выбранного модуля
        selectedModule?.LazyColumnContent()

        // Кнопка для показа диалогового окна
        Button(
//            onClick = { showDialog = true },
            onClick = { showDialog = !showDialog },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Показать диалог")
        }

        // Отображение диалогового окна, если оно активно
        if (showDialog) {
            selectedModule?.ShowDialog {
                showDialog = false
            }
        }
    }
}


