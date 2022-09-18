package com.example.kotlin_study2
//1. lamda
//value처럼 다룰 수 있는 익명함수
//-메소드 파라미터로 넘겨 줄수있다
//-return 값을 사용할 수 있다

//람다식 기본 정의
// val lamdaname : type = {argmentlist -> body}
//매개 변수 o 리턴 o
fun sqare(number : Int){
    val squarenumber = number*number
}
val squareLambda :(Int)->(Int) = {
        number -> number*number
}
var nameage ={
        name : String , age : Int -> "my name is ${name}, age is ${age}"
}
//매개 변수 X 리턴값 x
fun someFunction(){
    println("someFunction 함수를 호출하였습니다")
}

//매개 변수 x 리린턴값 x
val someLambda : () -> Unit = {
    println("someLambda가 호출되었습니다")
}

fun main(){
    println(squareLambda(12))
    println(nameage("chung", 26))

    someFunction()
    someLambda.invoke()

    val a = "han said"
    val b = "kim said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())
    println(extendString("han", 26))
    println(calculate(80))

    val lamda ={number : Double -> number==4.123}

    println(invokeLamda(lamda))
    println(invokeLamda({it>3.0}))
    println(invokeLamda { it>3.0 })
}

//확장함수

val pizzaIsGreat: String.() -> String = { this +"pizza is great"}

fun extendString( name : String, age :Int) : String{
    val introduce : String.(Int) -> String = {"my name is ${this}, age is ${it}"}
    return name.introduce(age)
}

//lamda return

val calculate: (Int)-> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..100-> "pass"
        else -> "error"
    }
}

//람다를 표현하는 여러가지 방법

fun invokeLamda( lamda :(Double) -> Boolean): Boolean {
    return lamda(4.123)
}

//람다