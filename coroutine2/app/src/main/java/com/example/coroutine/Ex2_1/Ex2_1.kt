package com.example.coroutine.Ex2_1

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*



import kotlinx.coroutines.runBlocking
import kotlin.random.Random


fun flowSomthing(): Flow<Int> = flow {
    repeat(10){
        emit(Random.nextInt(0,500))
    }
}
fun main() = runBlocking{
    flowSomthing().collect{
        value->println(value)
    }
}