package com.example.coroutine.Ex2_2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val value=(1..10).asFlow()
        .count{
            (it%2)==0
        }
    println(value)

}