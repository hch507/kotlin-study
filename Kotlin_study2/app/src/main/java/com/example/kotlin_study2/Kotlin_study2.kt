package com.example.kotlin_study2
//1. lamda
//value처럼 다룰 수 있는 익명함수
//-메소드 파라미터로 넘겨 줄수있다
//-return 값을 사용할 수 있다

//람다식 기본 정의
// val lamdaname : type = {argmentlist -> body}
//매개 변수 o 리턴 o
fun sqare(number : Int): Int {
    val squarenumber = number*number
    return squarenumber
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
// someFunction() => someLamda
//매개 변수 x 리린턴값 x
val someLambda : () -> Unit = {
    println("someLambda가 호출되었습니다")
}
//매개 변수 o 리턴값 x
val someLambdaWithParam : (String) -> Unit = {
    userImnput -> println("$userImnput")
}

//매개 변수 2개
val someLambdaWithParams : (String,Int) -> Unit = {
        userImnput, num -> println("$userImnput")
}
//매개 변수를 사용하지 않을 시 '_' 로 처리
//val someLamdaWithParams : (String,Int) -> Unit = {
//        userImnput,_ -> println("$userImnput")
//}

//함수의 매개변수로 람다를 사용 시
fun someFunctionWithLambda(completion: () -> Unit){
    completion()
}

fun someFunctionWithParamAndLambda(myNumber: Int, completion: (String) -> Unit){
    completion("myNumber는 $myNumber")
}


fun main(){
    println(squareLambda(12))
    println(nameage("chung", 26))

    someFunction()
    someLambda.invoke()
    someLambdaWithParam("호호호")
    someLambdaWithParams("호호호",1)

    someFunctionWithLambda(completion ={
        print("람다를 매개 변수로 사용하겼습니다.")
    })

    someFunctionWithParamAndLambda(300,completion ={
        print("받은 $it 입니다.")
    })


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