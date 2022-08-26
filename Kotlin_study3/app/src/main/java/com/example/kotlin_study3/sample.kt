package com.example.kotlin_study3

fun main(){
    var parent1 = parents()
    parent1.showhouse()

    var child1 = child()
    child1.showhouse()
}

//상속

open class parents(){
    var money = 5000
    //오버 라이딩
    open var house ="광주 광역시"

    open fun showhouse(){
        println("부모님의 집은 ${house}에 있다")
    }
}

class child : parents(){
    override var house = "천안시"
    fun showmoney(){
    println("내 부모님은 ${money}원 가지고 있어")
    }
    override fun showhouse(){
        println("나의 집은 ${house}에 있습니디")
    }
}