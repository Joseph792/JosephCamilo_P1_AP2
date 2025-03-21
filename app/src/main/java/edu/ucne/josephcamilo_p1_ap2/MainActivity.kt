package edu.ucne.josephcamilo_p1_ap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.josephcamilo_p1_ap2.data.local.database.J_Db
import edu.ucne.josephcamilo_p1_ap2.ui.theme.JosephCamilo_P1_AP2Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var j_Db: J_Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        j_Db = Room.databaseBuilder(
            applicationContext,
            J_Db::class.java,
            "J.db"
        ) .fallbackToDestructiveMigration()
            .build()

        /*setContent {
            JosephCamilo_P1_AP2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JosephCamilo_P1_AP2Theme {
        Greeting("Android")
    }
}