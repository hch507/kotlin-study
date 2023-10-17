package com.example.coroutine.Ex2_4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//collectLatest수집 측이 느릴 경우 새로운 데이터가 있을 떄 수집 측을 종료시키고 새로시작하는 방법도 있습니다.

fun simple3() : Flow<Int> = flow{
    for(i in 1..10){
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().collectLatest {
            value ->
            println("값 ${value}를 처리 하기 시작합니다.")
            delay(300)
            println(value)
            println("처리를 완료하였습니다")
        }
    }
    println("Collecte in $time ms")
}
