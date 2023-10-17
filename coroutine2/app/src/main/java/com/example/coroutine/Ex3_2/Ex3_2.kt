package com.example.coroutine.Ex3_2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

// 파이프라인은 일반적인 패턴입니다. 하나의 스트림을 프로듀서가 만들고, 다른 코루틴에서 그 스트림을 읽어 새로운 스트림을 만드는 패턴

private fun CoroutineScope.produceNumbers() = produce<Int>{//채널을 보내는 것
    var x = 1
    while(true) {
        send(x++)
    }
}

private fun CoroutineScope.produceStringNumbers(numbers: ReceiveChannel<Int>):ReceiveChannel<String> = produce{//위의 채널로 부터 받은 값을 다른 채널로 보냄
    for (i in numbers){
        send("$i!")
    }
}

fun main() = runBlocking<Unit>{
    val numbers = produceNumbers()
    val stringNumbers =produceStringNumbers(numbers)//receiveChannel을 통해 채널을 받을 수 있음 , 원래 채널은 recive+send

    repeat(5){
        println(stringNumbers.receive())
    }
    println("완료")
    coroutineContext.cancelChildren()
}