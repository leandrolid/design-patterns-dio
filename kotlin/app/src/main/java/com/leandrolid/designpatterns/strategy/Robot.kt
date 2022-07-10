package com.leandrolid.designpatterns.strategy

class Robot {

    private var behaviour: Behaviour? = null

    fun setBehaviour(behaviour: Behaviour?) {
        this.behaviour = behaviour
    }

    fun move() {
        behaviour?.move()
    }
}