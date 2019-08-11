package com.fpinkotlin.recursion.exercise16

fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iterate_(acc: List<T>, f: (T) -> T, seed: T): List<T> =
        if (acc.size < n) iterate_(acc + seed, f, f(seed)) else acc

    return iterate_(listOf(), f, seed)
}