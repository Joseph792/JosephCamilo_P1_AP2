package edu.ucne.josephcamilo_p1_ap2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.josephcamilo_p1_ap2.presentation.tarea.TareaListScreen
import edu.ucne.josephcamilo_p1_ap2.presentation.tarea.TareaScreen

@Composable
fun RegistroTareasNavHost(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.TareaList
    ) {
        //pantalla lista de tecnicos
        composable<Screen.TareaList>{

            TareaListScreen(
                goToTarea = { id ->
                    navHostController.navigate(Screen.Tarea(id ?: 0))
                },
                createTarea = {
                    navHostController.navigate((Screen.Tarea(0)))
                }
            )
        }

        //pantalla formulario de tecnico
        composable <Screen.Tarea>{ backStack ->
            val tareaId = backStack.toRoute<Screen.Tarea>().tareaId
            TareaScreen(
                tareaId = tareaId,
                //viewModel = tareasViewModel,
                goBack = { navHostController.popBackStack() }
            )
        }

    }
}