import com.lxp.study.*

fun main(args: Array<String>) {
//    println("Hello World!")
//    println(sum(1,2))
//    println(sum1(1,2))
//    println(sum2(1,2))
//    printSum(1,3)
//    printSum1(1,4)
//    vars(13,2,12,34,6,7,32,234,123)
//    println(sumLambda(1,5))
//    Var()
//    Var2()
//    StringTemp()
//
//    println(IsNull())
//    var s: String? = null
//    println(s ?: -1)
//    println(parseInt("22"))
//    TestParseInt(arrayOf("1","2","null"))
//    println(getStringLength("okaaaaaaaaaaaaaa"))
//    println(getStringLength2("okaaaaaaaaaaaaaa"))
//    println(getStringLength3("okaaaaaaaaaaaaaa"))
//    Ranges()
//
//    StringDo()
//
//    val price = """
//    ${'$'}9.99
//    """
//    println(price)
//    println(Conditon3(9))
//    println(Condition(12,9))
//
//    Condition2(201)

//    WhenTest(3)
//    WhenAny("rqwe")
//    WhenAny(99)
//
//    WhenItems()
//
//    ForTest()
//    WhileTest()

//    BreakTest()
//    LabelTest()

//    Foo()


//    var a : Runoob = Runoob()
//    a.foo()
//
//    //我们可以像使用普通函数那样使用构造函数创建类实例：
//    var b:Runoob2 = Runoob2()
//    println(b.city)
//
//    var c:Runoob3 = Runoob3("123")
//    c.GetName("lixueping")

//    var person:Person = Person()
//    person.lastName = "wang"
//    println("lastName:${person.lastName}")
//
//    person.no = 99
//    println("no:${person.no}")
//
//    person.no = 1
//    println("no:${person.no}")

//    var person:Person2 = Person2("LiXuePing")

//    var people:People = People("li","xueping")
//    people.printTest()
//    println(people.last)
//    println(people.first)
//    println(people.url)

//    var p: People3 = People3("中国人",1300000000)
//    println(p.url)
//    println(p.siteName)
//    println(p.country)
//    p.printTest()
//    p.printName()

//    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
//    println(demo)
//    var demo1 = Outer().GetSelf().GetSelf().Test()
//    var demo2 = Outer().Inner().innerTest()

//    var test = Test()
//    test.setInterface(object :TestInterFace{
//        override fun test() {
//            println("对象表达式穿件匿名内部类的实例")
//        }
//    })

//    val s = Student("lxp",18,"S9999",89)
//    println("学生名： ${s.name}")
//    println("年龄： ${s.age}")
//    println("学生号： ${s.no}")
//    println("成绩： ${s.score}")
//    var s =  Student("Runoob", 18, "S12345", 89)

//    var c = MyImpl()
//    c.foo()
//    c.bar()
//    println(c.name)

//    val d = DD()
//    d.foo()
//    d.bar()

//    var user = User("lxp")
//    user.Print()

//    val l = mutableListOf(1,2,3)
//    // 位置 0 和 2 的值做了互换
//    l.swap(0,2) // 'swap()' 函数内的 'this' 将指向 'l' 的值
//    println(l.toString())

//    printFoo(D())
//    var i = I()
//    i.fff()
//
//    var t = null
//    println(t.toString())

//    println("no:${Bs.no}")
//    Bs.foo()

//    val i:I = I()
//    val ii:II = II()
//    ii.caller(i)
//
//    val iii:III = III()
//    iii.caller(i)

    M2().caller(M())  // 输出 "M.foo in M2"
    M3().caller(M())  // 输出 "M.foo in M3" —— 分发接收者虚拟解析
    M2().caller(M1()) // 输出 "M.foo in M2" —— 扩展接收者静态解析
}