package com.fpinkotlin.recursion.exercise10


fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    var next = seed
    while (p(next)) {
        result.add(next)
        next = f(next)
    }
    return result
}

