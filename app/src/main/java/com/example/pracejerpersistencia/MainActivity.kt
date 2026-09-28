package com.example.pracejerpersistencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pracejerpersistencia.ui.theme.PracEjerPersistenciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracEjerPersistenciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        //Ejercicio1()//¿Qué significa persistir?
                        Ejercicio2()//remember y rememberSaveable
                    }
                }
            }
        }
    }
}
//Ejercicio 1 ¿Qué significa persistir?
@Composable
fun Ejercicio1(){
    Column() {
        Text(text = "Ejercicio 1", modifier = Modifier.padding(start = 175.dp, top = 10.dp))
        ExperimentoPersistencia()
    }
}
@Composable
fun ExperimentoPersistencia(){
    var nombre by remember { mutableStateOf("") }
    var contador by remember { mutableStateOf(0) }
    Column(modifier = Modifier.padding(8.dp)) {
        TextField(
            value = nombre,
            onValueChange = {nombre = it}, //Se ejecuta cada vez que el usuario escribe o modifica algo.
            // it representa el nuevo texto.
            label = {Text("Nombre")}
        )
        Text("Contador: $contador")
        Button(onClick = {contador+=1}) {
            Text("+1")
        }
        Button(onClick = {contador=0}) {
            Text("Reiniciar")
        }
    }
}

//Ejercicio 2 remember y rememberSaveable
@Composable
fun Ejercicio2(){
    Column() {
        Text(text = "Ejercicio 2", modifier = Modifier.padding(start = 175.dp, top = 10.dp))
        ExpPersist()
    }
}

@Composable
fun ExpPersist(){
    var nombre by rememberSaveable { mutableStateOf("") }
    var contador by rememberSaveable { mutableStateOf(0) } //aca el cambio
    Column(modifier = Modifier.padding(8.dp)) {
        TextField(
            value = nombre,
            onValueChange = {nombre = it}, //Se ejecuta cada vez que el usuario escribe o modifica algo.
            // it representa el nuevo texto.
            label = {Text("Nombre")}
        )
        Text("Contador: $contador")
        Button(onClick = {contador+=1}) {
            Text("+1")
        }
        Button(onClick = {contador=0}) {
            Text("Reiniciar")
        }
    }
}