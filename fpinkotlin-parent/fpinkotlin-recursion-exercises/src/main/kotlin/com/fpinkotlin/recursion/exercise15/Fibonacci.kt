package com.fpinkotlin.recursion.exercise15

import java.math.BigInteger


fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun fibo(number: Int): String {
    tailrec fun fibo_(acc: List<BigInteger>, x: BigInteger, y: BigInteger, z: BigInteger): List<BigInteger> {
        return when (z) {
            BigInteger.ZERO -> acc
            BigInteger.ONE -> acc + (x + y)
            else -> fibo_(acc + (x + y), y, x + y, x.dec())
        }
    }

    val result = fibo_(listOf(), BigInteger.ONE, BigInteger.ZERO, number.toBigInteger())
    return makeString(result, ", ")
}

fun <T> makeString(list: List<T>, separator: String): String {
    return when {
        list.isEmpty() -> ""
        list.tail().isEmpty() -> list.head().toString()
        else ->  list.head().toString() + foldLeft(list.tail(), "", {x, y -> "$x$separator$y"})
    }
}
