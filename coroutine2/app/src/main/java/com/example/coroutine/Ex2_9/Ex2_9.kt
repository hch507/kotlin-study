package com.example.coroutine.Ex2_9

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
// 이벤트 발생을 collect로 할 경우 이벤트가 끝날때까지 진행되지 않습니다.
private fun events() : Flow<Int> = (1..3).asFlow().onEach{delay(100)}
fun main() = runBlocking<Unit> {
    events()
        .onEach { event -> println("event $event") }
        .collect()
    println("Done")
}