package com.example.coroutine.Ex2_6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking


//flatMapMerge 첫요소의 프레트닝을 시작며 이어 다음 요소의 플레트닝을 시작합니다.
fun requestFlow2(i:Int) : Flow<String> = flow{
    emit("$i :first")
    delay(500)
    emit("$i: Second")
}

fun main() = runBlocking {
    val startTime =System.currentTimeMillis()
    (1..3).asFlow().onEach { delay(100) }
        .flatMapMerge {
            requestFlow2(it)
        }
        .collect{
                value-> println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}