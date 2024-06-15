package com.example.mainproject.commons.extensions

fun String.convertToMoneyWithSymbol() = "R$".plus(this.replace(".", ","))