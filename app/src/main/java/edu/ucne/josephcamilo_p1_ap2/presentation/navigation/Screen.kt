package edu.ucne.josephcamilo_p1_ap2.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object TareaList : Screen()
    @Serializable
    data class Tarea(val tareaId: Int?) : Screen()
}