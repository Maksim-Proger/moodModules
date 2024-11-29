package com.example.moodmodules

import com.example.christmas.ChristmasModule
import com.example.core.ContentModule
import com.example.newyear.NewYearModule
import com.example.halloween.HalloweenModule

class ModuleProvider {
    private val modules = listOf(
        ChristmasModule(),
        NewYearModule(),
        HalloweenModule()
    )

    fun getModuleByName(name: String): ContentModule? {
        return modules.firstOrNull { it.name == name }
    }
}

/**
 * Где разместить ModuleProvider:
 * ModuleProvider — это скорее класс инфраструктуры для предоставления доступа к модулям,
 * чем бизнес-логика. Поэтому его лучше всего разместить в Core или Domain слое в зависимости
 * от структуры вашего проекта.
 * Как это можно организовать:
 * Core или Domain Layer:
 *
 * Если ModuleProvider управляет бизнес-логикой, то его нужно разместить в Domain Layer. Это будет
 * слой, где будет описан интерфейс для работы с модулями.
 * Если же это скорее вспомогательный класс для инициализации и доступа к модулям, то его можно
 * поместить в Core Layer.
 */