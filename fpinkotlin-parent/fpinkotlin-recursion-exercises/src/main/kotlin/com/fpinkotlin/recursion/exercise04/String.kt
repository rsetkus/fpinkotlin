package com.fpinkotlin.recursion.exercise04

fun string(list: List<Char>): String {
    tailrec fun string_(acc: String, list: List<Char>): String {
        return when {
            list.isEmpty() -> acc
            else -> string_("$acc${list.head()}", list.tail())
        }
    }
    return string_("", list)
}

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
