package com.lxp.study

fun StringDo() {
    val text = """
    |多行字符串
    >|菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin(">")
    println(text)
}

fun Condition(a: Int,b : Int) :Int {
    var max : Int
    if (a>b) max=a else max = b
    return max
}

/**
 * 使用区间
使用 in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y ：
 * */
fun Condition2(a:Int) {
    if (a in 1..100) {
        println("x 在区间内 $a")
    } else {
        println("$a 不在区间内")
    }
}

fun Conditon3(a:Int) :Int {
    val max = if (a>10) {
        println("$a is big than 10")
        a
    } else {
        println("$a is small than 10")
        10
    }
    return max
}

/***
 * When 表达式
when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
when 类似其他语言的 switch 操作符。其最简单的形式如下：
 */
fun WhenTest(a:Int) {
    when (a) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            println("$a 不是1 也不是2")
        }
    }

    /**
     * 在 when 中，else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支。
    如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
     * */
    when (a) {
        3,4 -> println("x ==3 or x == 4")
        else -> println("overwirte")
    }

    /**
     * 我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
     * **/
    when (a) {
        in 1..10 -> print("x is in the range")
        !in 1..10 -> println("x is outside the range")
        else -> print("None of the above")
    }
}

/**
 * 另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。注意： 由于智能转换，你可以访问该类型的方法和属性而无需 任何额外的检测。
 * */
fun WhenAny(a: Any) {
    when(a){
        is String -> {
            a.startsWith("Prefix")
            println("string $a")
        }
        is Int -> {
            println(a.div(2))
        }
        else -> println("a is funny")
    }
}

//when 中使用 in 运算符来判断集合内是否包含某实例：
fun WhenItems() {
    val items = setOf("apple","banana","orange")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple pay is fine too")
    }
}

/*
* 注意这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。
或者你可以用库函数 withIndex：
* */
fun ForTest() {
    val items = listOf<String>("apple","banana","kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * do…while 循环 对于 while 语句而言，如果不满足条件，则不能进入循环。但有时候我们需要即使不满足条件，也至少执行一次。
do…while 循环和 while 循环相似，不同的是，do…while 循环至少会执行一次。
 * */
fun WhileTest() {
    println("---while使用---")
    var x = 5
    while (x>0) {
        println(x--)
    }
    println("---do..while----")
    var y = 5
    do {
        println(y--)
    } while (y>0)
}