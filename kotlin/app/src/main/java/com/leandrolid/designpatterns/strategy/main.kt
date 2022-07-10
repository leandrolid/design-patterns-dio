package com.leandrolid.designpatterns.strategy

fun main() {
    val regular = RegularBehaviour()
    val defensive = DefensiveBehaviour()
    val other = OtherBehaviour()
    val robot = Robot()

    robot.setBehaviour(regular)
    robot.move()
    robot.setBehaviour(defensive)
    robot.move()
    robot.setBehaviour(other)
    robot.move()
}