package com.fpinkotlin.functions.exercise02


fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

// Define a generic compose. The exercise dos not consist in writing the implementation, but the signature.
fun <T, T1, R> compose(f: (T) -> R, g: (T1) -> T): (T1) -> R = { f(g(it)) }