package com.lxp.study

/**
 * 返回和跳转
Kotlin 有三种结构化跳转表达式：
return。默认从最直接包围它的函数或者匿名函数返回。
break。终止最直接包围它的循环。
continue。继续下一次最直接包围它的循环。
 * */

//在循环中 Kotlin 支持传统的 break 和 continue 操作符。
fun BreakTest() {
    for (i in 1..10) {
        if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i>5) break  // i 为 6 时 跳出循环
    }
}

/**
 * Break 和 Continue 标签
在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可。
标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
 * */
fun LabelTest() {
    loop@ for (i in 1..100) {
        for (j in 1..i) {
            if (i*j > 100) println("i $i j $j")
            if (i*j > 1000) break@loop
        }
    }
}

/**
 * 标签处返回
Kotlin 有函数字面量、局部函数和对象表达式。因此 Kotlin 的函数可以被嵌套。 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。回想一下我们这么写的时候：
 * */
fun Foo() {
    var ints = listOf<Int>(1,2,3,1,1,1,1,1,1,13,3,2,2,3,3,23,2,3,23)
    ints.forEach listof@ {
//        if (it ==0 ) return@forEach
        if (it == 2) return@listof
        println(it)
    }
}