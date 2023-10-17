package com.example.coroutine.Ex3_3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//팬아웃 - 여러 코루틴이 동시에 채널을 구독할 수 있습니다.

private fun CoroutineScope.produceNumbers() = produce<Int>{
    var x =1
    while(true){
        send(x++)
        delay(100L)
    }
}

private fun CoroutineScope.processNumber(id :Int, channel : ReceiveChannel<Int>)= launch{
    channel.consumeEach{
        println("${id }가 ${it}을 받았습니다.")
    }
}
fun main() = runBlocking {
    val producer = produceNumbers()
    repeat(5){
        processNumber(it , producer)

    }
    delay(1000L)
    producer.cancel()
}