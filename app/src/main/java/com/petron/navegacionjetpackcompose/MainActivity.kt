package com.petron.navegacionjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petron.navegacionjetpackcompose.ui.theme.NavegacionJetpackComposeTheme
import com.petron.navegacionjetpackcompose.viewmodel.NavegacionViewModel

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val navegacionViewModel: NavegacionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()

            NavegacionJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Navegacion JetPack Compose")
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Greeting(appName: String) {

        var showFloatingAction = remember {
            mutableStateOf<Boolean>(true)
        }

        Scaffold(
            topBar = {
                SmallTopAppBar(title = { Text(text = appName) })
            },
            floatingActionButton = {
                if (showFloatingAction.value) {
                    FloatingActionButton(onClick = { navController.navigate("AddNote") }) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                modifier = Modifier.padding(it),
                startDestination = "List"
            ) {

                composable("List") {
                    showFloatingAction.value = true
                    NoteListPage()
                }

                composable("AddNote") {
                    showFloatingAction.value = false
                    AddNotePage()
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        NavegacionJetpackComposeTheme {
            Greeting("Navegacion JetPack Compose")
        }
    }

}