package com.leandrolid.designpatterns.facade.subsystemtwo

class CepApi private constructor() {
    companion object {
        private val instance: CepApi = CepApi()

        fun getInstance(): CepApi {
            return instance
        }
    }

    fun getCity(cep: String) = "Brasília"

    fun getState(cep: String) = "DF"
}