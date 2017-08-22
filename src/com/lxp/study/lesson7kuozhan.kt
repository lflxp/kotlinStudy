package com.lxp.study

/**
 * Created by lixueping on 2017/8/22.
 */

/**
 * Kotlin 扩展
Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式。
扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。
 * */

/*
扩展函数
扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式：
fun receiverType.functionName(params){
    body
}
receiverType：表示函数的接收者，也就是函数扩展的对象
functionName：扩展函数的名称
params：扩展函数的参数，可以为NULL
 */
class User(var name:String)

/**扩展函数**/
/*
var user = User("lxp")
user.Print()
 */
fun User.Print() {
    println("用户名 $name")
}

/*
val l = mutableListOf(1,2,3)
// 位置 0 和 2 的值做了互换
l.swap(0,2) // 'swap()' 函数内的 'this' 将指向 'l' 的值
println(l.toString())
 */
fun MutableList<Int>.swap(index1:Int,index2:Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * 扩展函数是静态解析的
扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
 * */
open class I {
    fun fff() {
        println("成员函数")
    }
}

class D: I()

fun I.foo() = "C" //扩展函数foo

fun D.foo() = "d" //扩展函数foo

fun D.fff() { println("扩展函数")}

fun printFoo(i:I) {
    println(i.foo()) //类型是I类
}

/*
若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
printFoo(D())
--> C

var i = I()
i.fff()
--> 成员函数
 */


/**
 * 扩展一个空对象
在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数。例如:
 * */
/*
var t = null
println(t.toString())
 */
fun Any?.toString() :String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

/**
 * >扩展属性
除了函数，Kotlin 也支持属性对属性进行扩展:
val <T> List<T>.lastIndex: Int
    get() = size - 1

扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
    val Foo.bar = 1 // 错误：扩展属性不能有初始化器

扩展属性只能被声明为 val。
 * */


/**
 * 伴生对象的扩展
如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
 * */
/*
println("no:${Bs.no}")
Bs.foo()
 */
class Bs {
    companion object { } // 将被称为 "Companion"
}

fun Bs.Companion.foo() {
    println("伴随对象的扩展函数")
}

val Bs.Companion.no :Int
    get() = 10

/**
 * 扩展的作用域
通常扩展函数或属性定义在顶级包下:
package foo.bar

fun Baz.goo() { …… }

要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:
package com.example.usage

import foo.bar.goo // 导入所有名为 goo 的扩展
// 或者
import foo.bar.*   // 从 foo.bar 导入一切

fun usage(baz: Baz) {
baz.goo()
}
 * */


/**
 * 扩展声明为成员
在一个类内部你可以为另一个类声明扩展。
在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
 * */
/*
val i:I = I()
val ii:II = II()
ii.caller(i)
 */
class II {
    fun baz() { println("II baz") }
    fun I.fof() {
        baz()  // 调用 II.bar
        foo()  // 调用 I.bar
        fff()
    }
    fun caller(i:I) {
        i.fof()  //调用扩展函数
    }
}

class III {
    fun bar() {println("III baz")}
    fun I.foo() {
        bar()  // 调用 I.bar()，扩展接收者优先
        this@III.bar() // 调用 III.bar()
    }
    fun caller(i:I) {
        i.foo()
    }
}

/**
 * 以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖. 也就是说, 在这类扩展函数的派 发过程中, 针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的。
 * */
/*

M2().caller(M())  // 输出 "M.foo in M2"
M3().caller(M())  // 输出 "M.foo in M3" —— 分发接收者虚拟解析
M2().caller(M1()) // 输出 "M.foo in M2" —— 扩展接收者静态解析
 */
open class M

class M1:M()

open class M2 {
    open fun M.foo() {
        println("M.foo in M2")
    }

    open fun M1.foo() {
        println("M1.foo in M2")
    }

    fun caller(m:M) {
        m.foo()
    }
}

class M3:M2() {
    override fun M.foo() {
        println("M.foo in M3")
    }

    override fun M1.foo() {
        println("M1.foo in M3")
    }
}