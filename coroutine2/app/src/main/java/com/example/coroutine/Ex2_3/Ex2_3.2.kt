package com.example.coroutine.Ex2_3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


// 다른 컨테스트로 옮겨갈수 없는 플로우
fun log2(msg : String) = println("[${Thread.currentThread().name }] $msg")

fun simple2() : Flow<Int> = flow{
    withContext(Dispatchers.Default){
        log2("flow를 시작합니다")
        for(i in 1..10){
            emit(i)
        }
    }

}

fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO){
        simple2()
            .collect{
                    value -> log2("$value 를 받음.")
            }
    }
}