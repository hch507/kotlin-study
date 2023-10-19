package com.example.coroutine.Ex1_4
import kotlinx.coroutines.*
//예외처리

suspend fun getNumber2():Int{
    try{
        delay(500L)
        return 13
    }finally {
        println("getNumber is cancell")
    }

}
suspend fun getNumber():Int{
    delay(500L)

    throw IllegalStateException()
}
suspend fun doSomething() = coroutineScope {
    val value1 = async { getNumber2() }
    val value2 = async{ getNumber() }
    try {
        println("${value1.await()}+${value2.await()}=${value1.await()+value2.await()}")
    }finally {
        println("dosomething is cancelled")
    }
}
fun main() = runBlocking {
    try {
        doSomething()
    } catch (e: IllegalStateException) {
        println("doSomething failed: $e")
    }
}
