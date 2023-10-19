package com.example.coroutine.Ex1_4
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//async를 이용해 동시에 SUSPEND 실행하기
suspend private fun getRandom() :Int{
    delay(1000L)
    return 13
}
suspend private fun getRandom2() :Int{
    delay(1000L)
    return 29
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async{getRandom()}
        val value2 = async{getRandom2()}

        println("${value1.await()}+${value2.await()}=${value1.await()+value2.await()}")
    }
    print(elapsedTime)
}