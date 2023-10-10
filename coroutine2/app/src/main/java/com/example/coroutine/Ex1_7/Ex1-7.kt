package com.example.coroutine.Ex1_7

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

//////////공유 객체 문제

suspend fun massiveRun(action: suspend () -> Unit){
    val n =100
    val k = 1000
    val elapsed = measureTimeMillis{
        coroutineScope{
            repeat(n){
                launch{
                    repeat(k) {action}
                }
            }
        }
    }
    println("$elapsed ms 동안 ${n*k}개의 액션을 수행했습니다.")

}

var counter =0

fun main() = runBlocking {

    withContext(Dispatchers.Default){
        massiveRun {
            counter++
        }
    }
    println("Coutner =$counter")
}