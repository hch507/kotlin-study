package com.example.coroutine.Ex2_2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking
///////fold
fun main() = runBlocking {
    val value=(1..10).asFlow()
        .fold(10){
                a, b -> a+b
        }
    println(value)

}