package com.example.calculadora.presentation

import java.text.NumberFormat

fun formattedJuros (
    valorEmprestado: Double?,
    taxaJuros: Double?,
    numMeses:Double?,
    ):String{
    if(valorEmprestado==null||taxaJuros==null||numMeses==null){
        return "Digite valores válidos"
    }
    val resultado = valorEmprestado*Math.pow(1+taxaJuros/100, numMeses)
    val textResultado = NumberFormat.getNumberInstance().format(resultado)
    return "Seu total com o juros é $textResultado"
}