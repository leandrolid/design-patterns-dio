package com.leandrolid.designpatterns.strategy

class DefensiveBehaviour : Behaviour {

    override fun move() {
        println("defensive movement")
    }
}