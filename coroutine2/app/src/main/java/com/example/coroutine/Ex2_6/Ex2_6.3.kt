package com.example.coroutine.Ex2_6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking


//flatMapLatest 는 다음 요소의 프레트닝을 시작하며 이전에 진행중이던 프레트닝을 취소합니다.
fun requestFlow3(i:Int) : Flow<String> = flow{
    emit("$i :first")
    delay(500)
    emit("$i: Second")
}

fun main() = runBlocking {
    val startTime =System.currentTimeMillis()
    (1..3).asFlow().onEach { delay(100) }
        .flatMapLatest {
            requestFlow3(it)
        }
        .collect{
                value-> println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}