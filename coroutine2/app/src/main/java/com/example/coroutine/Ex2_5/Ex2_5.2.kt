package com.example.coroutine.Ex2_5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val nums =(1..3).asFlow().onEach { delay(100L) }
    val strs = flowOf("일","이","삼").onEach { delay(200L) }

    nums.combine(strs){a,b ->"$a 는 $b"}
        .collect{println(it)}

}