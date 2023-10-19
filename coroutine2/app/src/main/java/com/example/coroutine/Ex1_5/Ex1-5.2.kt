package com.example.coroutine.Ex1_5

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
//부모가 있는 Job과 없는 Job //구조적 동시성을 무시하게됨 launch(job)을 만들면 부모와의 관꼐를 끊음
//fun main() = runBlocking<Unit> {
//    val job = launch {
//        launch(Job()) { //(Job())의 선언으로 부모와 연결되지 않은 별도의 코루틴
//            println(coroutineContext[Job])
//            println("launch1: ${Thread.currentThread().name}")
//            delay(1000L)
//            println("3!")
//        }
//
//        launch(Job()) {
//            println(coroutineContext[Job])
//            println("launch1: ${Thread.currentThread().name}")
//            delay(1000L)
//            println("1!")
//        }
//    }
//    delay(500L)
//    job.cancelAndJoin()
//    delay(1000L)
//}

/////코루틴 엘리먼트 결합
////여러 코루틴 엘리먼트를 한번에 사용할 수 있다 +연산으로 엘리먼트를 합치면 된다. 합쳐진 엘리먼트들은 coroutineContext[]로 조회할 수 있다.
///코루틴 컨텍스트는 부모와 자식의 컨텍스트 가지고있음
@OptIn(ExperimentalStdlibApi::class)
fun main()= runBlocking<Unit> {
    launch {
        launch(Dispatchers.IO + CoroutineName("launch1")) {
            println("launch1 : ${Thread.currentThread().name}")
            println(coroutineContext[CoroutineDispatcher])
            println(coroutineContext[CoroutineName])
            delay(5000L)
        }
//        launch(Dispatchers.Default + CoroutineName("launch1")) {
        launch(Dispatchers.Default + CoroutineName("launch1")) {
                println("launch1 : ${Thread.currentThread().name}")
                println(coroutineContext[CoroutineDispatcher])
                println(coroutineContext[CoroutineName])
                delay(5000L)
        }
    }
}
