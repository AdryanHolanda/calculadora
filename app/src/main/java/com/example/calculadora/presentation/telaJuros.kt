package com.example.calculadora.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun telaJuros(modifier: Modifier = Modifier) {
    var valorEmprestadoText by remember { mutableStateOf("") }
    var taxaJurosText by remember { mutableStateOf("") }
    var numMesesText by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    val valorEmprestado = valorEmprestadoText.toDoubleOrNull()
    val taxaJuros = taxaJurosText.toDoubleOrNull()
    val numMeses = numMesesText.toDoubleOrNull()

    val onclick = { resultado = formattedJuros(valorEmprestado, taxaJuros, numMeses) }

    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = valorEmprestadoText,
            onValueChange = { novoValor ->
                valorEmprestadoText = novoValor
            },
            label = { Text("Digite o valor que pegou emprestado") }
        )

        TextField(
            value = taxaJurosText,
            onValueChange = { novoValor ->
                taxaJurosText = novoValor
            },
            label = { Text("Digite o total de Juros (%)") }
        )

        TextField(
            value = numMesesText,
            onValueChange = { novoValor ->
                numMesesText = novoValor
            },
            label = { Text("Digite o número de meses") }
        )

        Button(onClick = onclick) {
            Text("Calcular Juros")
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = resultado,
        fontSize = 30.sp,
        modifier = modifier
    )
}
