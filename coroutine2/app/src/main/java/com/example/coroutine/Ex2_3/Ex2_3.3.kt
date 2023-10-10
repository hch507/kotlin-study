package com.example.coroutine.Ex2_3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

///flowOn연산자를 통해 context를 이동할 수 있음
fun log3(msg : String) = println("[${Thread.currentThread().name }] $msg")

fun simple3() : Flow<Int> = flow{

    for(i in 1..10){
        log3("값 ${i}을 emit합니다")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking<Unit> {
    launch(){
        simple3()
            .collect{
                    value -> log3("$value 를 받음.")
            }
    }
}