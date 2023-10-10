package com.example.coroutine.Ex2_1

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

////flow 빌더함수 - flowOf()
fun main() = runBlocking {
    flowOf(1,2,3,4,5).collect{value->
        println(value)
    }
    flow{
        emit(1)
        emit(2)
        emit(3)
        emit(4)
    }.collect{
        value ->println(value)
    }
}