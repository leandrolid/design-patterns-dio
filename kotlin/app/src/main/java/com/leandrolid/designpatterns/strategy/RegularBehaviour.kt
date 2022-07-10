package com.leandrolid.designpatterns.strategy

class RegularBehaviour : Behaviour {

    override fun move() {
        println("regular movement")
    }
}