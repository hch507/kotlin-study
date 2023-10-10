package com.example.coroutine.Ex2_2

import com.example.coroutine.Ex2_1.flowSomthing
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun flowSomething(): Flow<Int> = flow{
    repeat(10){
        emit(Random.nextInt(0,500))
        delay(10L)
    }
}

fun main() = runBlocking {
    flowSomthing().map{
        "$it $it"
    }.collect{
        println(it)
    }
}