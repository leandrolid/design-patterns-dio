package one.digitalinnovation.gof.model

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do ViaCEP.
 *
 * @see [jsonschema2pojo.org](https://www.jsonschema2pojo.org)
 *
 * @see [ViaCEP](https://viacep.com.br)
 *
 *
 * @author falvojr
 */
@Entity
data class Address(
    @Id
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
)