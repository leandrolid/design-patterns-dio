package com.leandrolid.designpatterns.facade.subsystemone

class CrmService private constructor() {

    companion object {
        fun insertClient(name: String, cep: String, state: String, city: String) {
            println("client inserted with data")
            println("name: $name")
            println("cep: $cep")
            println("city: $city")
            println("state: $state")
        }
    }
}