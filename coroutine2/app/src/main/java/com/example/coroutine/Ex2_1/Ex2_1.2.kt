package com.example.coroutine.Ex2_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random


///////////플로우 취소
///////////withTimeoutOrNull로 취소 가능
fun flowSomething(): Flow<Int> = flow{
    repeat(10){
        emit(Random.nextInt(0, 500))
        delay(100L)
    }
}

fun main()=runBlocking{
    val result = withTimeoutOrNull(500L){
        flowSomething().collect{ value->
        println(value)
        }
        true
    } ?: false

    if(result){
        println("취소되었습니다")
    }
}