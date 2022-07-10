package com.leandrolid.designpatterns.singleton

class SingletonLazy private constructor() {
    companion object {
        private var instance: SingletonLazy? = null

        fun getInstance(): SingletonLazy? {
            if (instance == null) {
                instance = SingletonLazy()
            }
            return instance
        }
    }
}