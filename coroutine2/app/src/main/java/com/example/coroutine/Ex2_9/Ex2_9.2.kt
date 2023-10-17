package com.example.coroutine.Ex2_9

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

//이벤트의 경우 collect가 아닌 launchIn을 통해 별로의 코루틴에서 플로우를 런칭할 수 있다
private fun events() : Flow<Int> = (1..3).asFlow().onEach{ delay(100) }
fun main() = runBlocking<Unit> {
    events()
        .onEach { event -> println("event $event") }
        .launchIn(this)//코루틴 스코프 // 새로운 코루틴
    println("Done")
}