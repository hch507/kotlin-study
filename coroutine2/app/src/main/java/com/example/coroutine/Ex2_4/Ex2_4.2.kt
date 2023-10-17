package com.example.coroutine.Ex2_4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

///////conflate를 이용하면 처리보다 빨리 발생한 데이터의 중간 값들을 누락합니다.

fun simple2(): Flow<Int> = flow{
    for(i in 1..10){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple2().conflate()
            .collect{
                    value->
                delay(300L)
                println(value)
            }
    }
    println("Collected in $time ms")
}