package com.leandrolid.designpatterns.singleton

class SingletonEager private constructor() {
    companion object {
        private val instance = SingletonEager()

        fun getInstance(): SingletonEager {
            return instance
        }
    }
}