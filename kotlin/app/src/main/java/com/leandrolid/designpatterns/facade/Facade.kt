package com.leandrolid.designpatterns.facade

import com.leandrolid.designpatterns.facade.subsystemone.CrmService
import com.leandrolid.designpatterns.facade.subsystemtwo.CepApi

class Facade {

    fun migrateClient(name: String, cep: String) {
        val state = CepApi.getInstance().getState(cep)
        val city = CepApi.getInstance().getCity(cep)

        CrmService.insertClient(name, cep, state, city)
    }
}