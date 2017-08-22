package com.lxp.study

import java.lang.reflect.Array

//函数定义使用关键字 fun，参数格式为：参数 : 类型
fun sum(a: Int,b: Int) :Int {
    return a+b
}

//表达式作为函数体，返回类型自动推断：
fun sum1(a: Int,b: Int) = a + b

// public 方法则必须明确写出返回类型
public fun sum2(a: Int,b: Int) :Int = a+b

//无返回值的函数(类似Java中的void)：
fun printSum(a: Int,b: Int) :Unit {
    println(a+b)
}

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun printSum1(a: Int,b: Int) {
    println(a+b)
}

//函数的变长参数可以用 vararg 关键字进行标识：
fun vars(vararg v:Int) {
    for(vt in v) {
        print(vt)
    }
    println()
}

//lambda(匿名函数)
val sumLambda:(Int,Int) -> Int = {x,y -> x+y}

/**
定义常量与变量
可变变量定义：var 关键字
var <标识符> : <类型> = <初始化值>
不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
val <标识符> : <类型> = <初始化值>
常量与变量都可以没有初始化值,但是在引用前必须初始化
编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断。
 */

val a: Int = 1
val b = 1      // 系统自动推断变量类型为Int

fun Var() {
    val C: Int  // 如果不在声明时初始化则必须提供变量类型
    C = 1       // 明确赋值
    println(C)
}

fun Var2() {
    var x = 5  // 系统自动推断变量类型为Int
    x += 11    // 变量可修改
    println(x)
}

//注释
//Kotlin 支持单行和多行注释，实例如下：
// 这是一个单行注释

/* 这是一个多行的
   块注释。 */

/**
字符串模板
$ 表示一个变量名或者变量值
$varName 表示变量值
${varName.fun()} 表示变量的方法返回值:
*/

fun StringTemp() {
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"
    println(s1)

    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is","was")},but now is $a"
    println(s2)
}

/**
 * NULL检查机制
Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
 * */

fun IsNull() :Int? {
    //类型后面加?表示可为空
    var age: String? = "23"
    println(age)
    //抛出空指针异常
    val ages = age!!.toInt()
    println(ages)
    //不做处理返回null
    val ages1 = age?.toInt()
    println(ages1)
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println(ages2)
    return ages2
}

/**
 * 当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null。
当 str 中的字符串内容不是一个整数时, 返回 null:
 */
fun parseInt(str: String) :Int? {
    val a = str?.toInt()
    return a
}


//TestParseInt(arrayOf("1","2","null"))
fun TestParseInt(args: kotlin.Array<String>) {
    if (args.size < 2){
        println("Tow integers expected")
        return
    }
    var x = parseInt(args[0])
    var y = parseInt(args[1])
    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
    if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        println(x*y)
    } else {
        println("some one like null")
    }
}

/**
 * 类型检测及自动类型转换
我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
 * */
fun getStringLength(obj: Any) : Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }
    //在这里还有一种方法，与Java中instanceof不同，使用!is
    // if (obj !is String){
    //   // XXX
    // }

    //这里的obj仍然是Any类型的引用
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String)
        return null
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
    if (obj is String && obj.length > 0)
        return obj.length
    return null
}

/**
 * 区间
区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例:
 * */
fun Ranges() {
    for (i in 1..10) println(i)
    for (i in 4..1) println(i) // 什么都不输出

    for (ii in 1..10) {
        println(ii)
    }

    // 使用 step 指定步长
    for (i in 1..4 step 2) println(i)

    for (i in 20 downTo 1 step 2) print(i)

    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {  // i in [1, 10) 排除了 10
        println(i)
    }
}