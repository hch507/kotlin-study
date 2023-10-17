package com.example.coroutine.Ex3_2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
//파이프라인을 이용하여 홀수 필터를 만들어 봅시다.
private fun CoroutineScope.produceNumbers() = produce<Int>{
    var x =1
    while(true){
        send(x++)
    }
}
fun CoroutineScope.filterOdd(numbers: ReceiveChannel<Int>) : ReceiveChannel<String> = produce {
    for ( i in numbers){
        if ( i % 2 ==1){
            send("$i!")
        }
    }
}

fun main()= runBlocking {
    val numbers = produceNumbers()
    val oddNumbers = filterOdd(numbers)

    repeat(10){
        println(oddNumbers.receive())
    }
    println("완료")
}
