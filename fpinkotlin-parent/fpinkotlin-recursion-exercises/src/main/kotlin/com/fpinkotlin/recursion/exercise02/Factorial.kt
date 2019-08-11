package com.fpinkotlin.recursion.exercise02

object Factorial {
    // Cannot execute because `x` is not initialized yet!
    //val x: Int = x + 1
    val x: Int by lazy {
        x + 1
    }

    val factorial1: (Int)-> Int = {
        tailrec fun factorialRecursive(n: Int): Int = if (n <= 1) 1 else n * factorialRecursive(n - 1)
        factorialRecursive(it)
    }

    val factorial: (Int)-> Int by lazy {
        { n: Int -> if (n <= 1) 1 else n * factorial(n - 1) }
    }
}