package com.example.kotlin_study1

fun main(){
    //print(add(5,3))

    //3. string template
//    val name ="Chungh ee"
//    val lastname = "Han"
//    print("my name is ${name+lastname} ")

//    println(maxby(3,4))
//    println(maxby1(3,4))

//    checkNum(1)

//    forAndWhile()

//    nullcheck()

    val human = Human("minsu")
    val human2 = Human()
    val human3 = Human("doa", 27)
    human.introduce()
    println("my friend is ${human.name}")
    println("my friend is ${human2.name}")

}
//1. 함수

fun HellowWorld() {
    print("hellow")
}

fun add(a :Int, b :Int) : Int{
    return a+b
}

//2. val, var
//val : 변할 수 없는 값
//var : 뱐할 수 잇는 값
fun hi(){
    var a : Int =10
    val b : Int =20
}

//4. 조건식
fun maxby(a:Int, b:Int) : Int {

    if(a>b){
        return a
    }else{
        return b
    }
}

fun maxby1( a : Int, b: Int) = if(a>b) a else b

fun checkNum(score :Int){
    when(score){
        0-> println("this is 0")
        1-> println("this is 1")
        2,3-> println("this is 2 or 3")

    }
    var c = when(score){ // 이럴 경우 else를 필수로 써주어야합니다
        1-> 1
        2-> 2
        else->3
    }
    println("c : ${c}")

    when(score){
        in 90..100 -> println("good")
        in 10..90 -> println("not bad")
        else -> println("oh...")
    }
}

//5. Array -> 읽고 쓰기 가능
fun array(){
    val arr = arrayOf(1,2,3)
    val arr2 = arrayOf(1,"num",2 )

    arr[0]
}
//5. list - list -> 일기만 가능
//          mutablelist(arrayList) -> 읽고 쓰기 가능

fun list(){
    val list1 = listOf(1,2,3)
    val list2 = listOf(1,"num",3)
    list1.get(0)

    val arraylist = arrayListOf<Int>()
    arraylist.add(10)
}
//map =(키 : 값)
fun map(){
    var mutablemap = mutableMapOf<String, String>()

    mutablemap.put("이름","한충희")
    println("${mutablemap.get("이름")}")
}

//6. for amd while

fun forAndWhile(){
    val name = arrayListOf("chung","doa","lotto", "liy")

    for( i in name){
        println("${i}")
    }

    var index =0

    while(index<10){
        index +=1
        println("${index}")
    }

}

//7. Nullable, Nonnull
fun nullcheck(){
    var name : String = "chung"
    //var nullname :String = null  String 에 널값을 넣을 시 오류
    var nullname : String? =null // ? 사용시 null 사용가능
    var nullnameInuppercase : String? = nullname?.toUpperCase()

    // ?:
    var lastname : String? = null
    var fullname : String = name + (lastname?: "Han")

    println("${fullname}")

}

fun ignoreNull(str : String?){
    val name : String = str!! //  절대 null이 아니다
    var nullnameInuppercase : String = name.toUpperCase() // ? 없이 사용 가능
    val email : String?= "hchxxx@xxxxx.xxx"

    email?.let {
        print("${email}") // email이 null 이 아닐 경우 실행
   }
}

//8. class

class Human(val name :String ="minjun"){
    //companion object는 클래스를 초기화 하지 않고 사용 가능
    companion object{
        val a = "chung"
    }

    init{ // 주생성자
        println("imtroduce")
    }
    constructor(name : String , age : Int) : this(name){ // 부생성자
        println("name is ${name}, age is ${age}")
    }
    fun introduce(){
        println("my name is chunghee Han")
    }
}