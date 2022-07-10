package one.digitalinnovation.gof.service

import one.digitalinnovation.gof.model.Address
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Client HTTP, criado via **OpenFeign**, para o consumo da API do
 * **ViaCEP**.
 *
 * @see [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
 *
 * @see [ViaCEP](https://viacep.com.br)
 *
 *
 * @author falvojr
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
interface ViaCepService {
    @GetMapping("/{cep}/json/")
    fun getAddressByZipCode(@PathVariable("cep") cep: String): Address
}