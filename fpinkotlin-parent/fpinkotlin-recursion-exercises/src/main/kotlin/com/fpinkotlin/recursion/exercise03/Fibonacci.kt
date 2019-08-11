package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger

fun fib(n: Int): BigInteger {
    tailrec fun fib_(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger {
        return when {
            (x == BigInteger.ZERO) -> BigInteger.ONE
            (x == BigInteger.ONE) -> val1 + val2
            else -> fib_(val2, val1 + val2, x.dec())
        }
    }
    return fib_(BigInteger.ZERO, BigInteger.ONE, n.toBigInteger())
}
