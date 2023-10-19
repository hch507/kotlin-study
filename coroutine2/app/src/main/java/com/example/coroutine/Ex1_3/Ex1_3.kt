package com.example.coroutine.Ex1_3
import kotlinx.coroutines.*
//finally를통해 외부에서 코루틴 취소가 생길시 자원을 정리함 예)파일 열고 닫기

suspend private fun doOneTwoThree() = coroutineScope{
    val job1 =launch {
        try {
            println("${Thread.currentThread().name}")
            delay(1000L)
            println("3")
        }finally {
            println("jpbis finishing!")
            //파일을 닫는 코드
        }
    }
    val job2 =launch {
        try {
            println("${Thread.currentThread().name}")
            delay(1000L)
            println("2")
        }finally {
            println("jpbis finishing!")
        }
    }
    delay(800L)
    job1.cancel()
    job2.cancel()
    println("4")
}
fun main() = runBlocking {
    doOneTwoThree()

}


