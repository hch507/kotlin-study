package com.example.coroutine.Ex1_6.`Ex1-6`

import com.example.coroutine.Ex1_6.printRandom
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

////코루틴 익셉션 핸들러(CEH)
////예외를 가장 체계적으로 다루는 방법은 CEH를 사용하는 것
////CoroutineExceptionHandler를 이용해서 우리만의 CEH를 만든 다음 상위 코루틴 빌더의 컨텍스트에 등록합니다.
suspend fun printRandom1(){
    delay(1000L)
    println(Random.nextInt(0,500))

}
suspend fun printRandom2(){
    delay(500L)
    throw ArithmeticException()
}
val ceh = CoroutineExceptionHandler{
    coroutineContext, exception -> println("Somthing happend: $exception")
}
fun main()= runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch(ceh+ CoroutineName("hch")) {
        println(coroutineContext)
        launch { printRandom1() }
        launch { printRandom2() }
    }
    job.join()

}