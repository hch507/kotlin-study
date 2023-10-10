package com.example.coroutine.Ex2_2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.runBlocking
////////filter
fun main() = runBlocking {
//    (1..10).asFlow().filter {
//        (it%2) ==0
//    }.collect{
//        value -> println(value)
//    }
    (1..10).asFlow().filterNot {
        (it%2) ==0
    }.collect{
            value -> println(value)
    }
}