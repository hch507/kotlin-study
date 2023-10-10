package com.example.coroutine.Ex1_6.`Ex1-6`

import com.example.coroutine.Ex1_6.printRandom
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.random.Random

suspend fun printRandom3(){
    delay(500L)
    println(Random.nextInt(0,500))
}
suspend fun printRandom4() {
    delay(500L)
    throw ArithmeticException()
}

suspend fun supervisoreFunc()= supervisorScope{
    launch { printRandom3() }
    launch { printRandom4()}
}
fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch { supervisoreFunc() }

}