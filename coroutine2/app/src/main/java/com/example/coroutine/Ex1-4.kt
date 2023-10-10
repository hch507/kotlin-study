package com.example.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

////////////////async(start = CoroutineStart.LAZY){} - > .start를통해 코루틴 시작점을 정할 수 있다.
//suspend fun getRandom() :Int{
//    delay(1000L)
//    return 13
//}
//suspend fun getRandom2() :Int{
//    delay(1000L)
//    return 29
//}
//
//fun main() = runBlocking {
//    val elapsedTime = measureTimeMillis {
//        val value1 = async(start = CoroutineStart.LAZY){getRandom()}
//        val value2 = async(start = CoroutineStart.LAZY){ getRandom2() }
//
//        value1.start()
//        value2.start()
//        println("${value1.await()}+${value2.await()}=${value1.await()+value2.await()}")
//    }
//    print(elapsedTime)
//}

///////////////////////value 2에서 문제가 발생하여 부모 코루틴 doSomthing이 취소되고 자식 코루틴 value1도 취소됨
//suspend fun getNumber2():Int{
//    try{
//        delay(500L)
//        return 13
//    }finally {
//        println("getNumber is cancell")
//    }
//
//}
//suspend fun getNumber():Int{
//    delay(500L)
//
//    throw IllegalStateException()
//}
//suspend fun doSomething() = coroutineScope {
//    val value1 = async { getNumber2() }
//    val value2 = async{ getNumber() }
//    try {
//        println("${value1.await()}+${value2.await()}=${value1.await()+value2.await()}")
//    }finally {
//        println("dosomething is cancelled")
//    }
//}
//fun main() = runBlocking {
//    try {
//        doSomething()
//    }catch (e: IllegalStateException){
//        println("doSomething failed: $e")
//    }
//
//}