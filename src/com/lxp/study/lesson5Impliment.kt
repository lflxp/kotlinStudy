package com.lxp.study

import jdk.nashorn.internal.runtime.Context
import javax.swing.text.AttributeSet

/**
 * Kotlin 继承
Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类：
Any 默认提供了三个函数：
equals()

hashCode()

toString()
注意：Any 不是 java.lang.Object。
如果一个类要被继承，可以使用 open 关键字进行修饰。
 * */
class Example // 从 Any 隐式继承

open class BaseExample(p:Int) //定义基类

class Deruvedd(p:Int) :BaseExample(p)

/**
 * 构造函数
子类有主构造函数
如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
 * */
/*
val s = Student("lxp",18,"S9999",89)
println("学生名： ${s.name}")
println("年龄： ${s.age}")
println("学生号： ${s.no}")
println("成绩： ${s.score}")
 */
open class PersonOne(var name:String,var age:Int) {} //基类

class Student(name: String,age: Int,var no:String,var score:Int) :PersonOne(name,age) {}

/**
 * 子类没有主构造函数
如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
 * */

/**用户基类**/
open class Persons(name:String){
    /**次级构造函数**/
    constructor(name:String,age:Int):this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }
}

/**子类继承 Person 类**/
class Students:Persons{

    /**次级构造函数
     * super继承父类的主构造函数
     * **/
    constructor(name:String,age:Int,no:String,score:Int):super(name,age){
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

/**
 * 重写
在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词：
 * */
/**用户基类**/
open class Person2s{
    open fun study(){       // 允许子类重写
        println("我毕业了")
    }
}

/**子类继承 Person 类**/
class Student2 : Person2s() {

    override fun study(){    // 重写方法
        println("我在读大学")
    }
}

/*
如果有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现。
 */
open class A {
    open fun f () { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } //接口的成员变量默认是 open 的
    fun b() { print("b") }
}

/**C 继承自 a() 或 b(), C 不仅可以从 A 或则 B 中继承函数，而且 C 可以继承 A()、B() 中共有的函数。此时该函数在中只有一个实现，为了消除歧义，该函数必须调用A()和B()中该函数的实现，并提供自己的实现。**/
class C() : A() , B{
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

/**
 * 属性重写
属性重写使用 override 关键字，属性必须具有兼容类型，每一个声明的属性都可以通过初始化程序或者getter方法被重写：
 * */
open class Foo2 {
    open val x: Int
        get() {
            println("ok")
            return 8
        }
}

class Bar1 : Foo2() {
    override val x: Int = 99
}

/*
你可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
 */
interface Foo {
    val count: Int
}

class Bar1s(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}