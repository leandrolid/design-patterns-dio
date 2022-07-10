package com.leandrolid.designpatterns.singleton

fun main() {
    println(SingletonLazy.getInstance())
    println(SingletonLazy.getInstance())
    println(SingletonLazy.getInstance())

    println("---------------------------------------")

    println(SingletonEager.getInstance())
    println(SingletonEager.getInstance())
    println(SingletonEager.getInstance())

    println("---------------------------------------")

    println(SingletonLazyHolder.getInstance())
    println(SingletonLazyHolder.getInstance())
    println(SingletonLazyHolder.getInstance())
}