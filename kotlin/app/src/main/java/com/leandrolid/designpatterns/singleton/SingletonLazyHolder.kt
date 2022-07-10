package com.leandrolid.designpatterns.singleton

class SingletonLazyHolder private constructor() {

    private object InstanceHolder {
        var instance = SingletonLazyHolder()
    }

    companion object {
        fun getInstance(): SingletonLazyHolder {
            return InstanceHolder.instance
        }
    }
}