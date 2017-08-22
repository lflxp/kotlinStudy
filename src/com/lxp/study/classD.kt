package com.lxp.study

/**
 * 类的修饰符
类的修饰符包括 classModifier 和_accessModifier_:
classModifier: 类属性修饰符，标示类本身特性。
abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
accessModifier: 访问权限修饰符
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
 * **/
private fun foo() {}    // 在 example.kt 内可见
public var bar:Int = 5  // 该属性随处可见
internal val baz = 6    // 相同模块内可见
