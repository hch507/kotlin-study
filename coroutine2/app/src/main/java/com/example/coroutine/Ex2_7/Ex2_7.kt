package com.example.coroutine.Ex2_7

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
////////////////다시 학습하기
fun simple() : Flow<Int> = flow{
    for (i in 1..3){
        println("emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    try{
        simple().collect{value ->
            println(value)
            check(value <=1){
                "Collect $value"
            }
        }
    }catch (e : Throwable){
        println("Caught $e")

    }
}