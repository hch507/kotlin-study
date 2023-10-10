package com.example.coroutine.Ex2_2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

//////reduce
fun main() = runBlocking {
    val value=(1..10).asFlow()
        .reduce{
        a, b -> a+b
    }
    println(value)

}