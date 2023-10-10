package com.example.coroutine.Ex1_6

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.random.Random

suspend fun printRandom1(){
    delay(1000L)
    println(Random.nextInt(0,500))

}
suspend fun printRandom2(){
    delay(500L)
    throw ArithmeticException()
}
val ceh1 = CoroutineExceptionHandler{
        coroutineContext, exception -> println("Somthing happend: $exception")
}

fun main()= runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO + ceh1 + SupervisorJob())
    val job = scope.launch { printRandom2() }
    val job2 = scope.launch { printRandom1()}
    joinAll(job,job2)

}