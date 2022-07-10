package one.digitalinnovation.gof.service.impl

import one.digitalinnovation.gof.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import one.digitalinnovation.gof.model.ClientRepository
import one.digitalinnovation.gof.model.AddressRepository
import one.digitalinnovation.gof.model.Client
import one.digitalinnovation.gof.service.ViaCepService
import org.springframework.stereotype.Service

/**
 * Implementação da **Strategy** [ClientService], a qual pode ser
 * injetada pelo Spring (via [Autowired]). Com isso, como essa classe é um
 * [Service], ela será tratada como um **Singleton**.
 *
 * @author falvojr
 */
@Service
class ClientServiceImpl : ClientService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private val clientRepository: ClientRepository? = null

    @Autowired
    private val addressRepository: AddressRepository? = null

    @Autowired
    private val viaCepService: ViaCepService? = null

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    override fun getAll(): Iterable<Client> {
        return clientRepository!!.findAll()
    }

    override fun getById(id: Long): Client {
        val client = clientRepository!!.findById(id)
        return client.get()
    }

    override fun insert(client: Client) {
        saveClientWithZipCode(client)
    }

    override fun update(id: Long, client: Client) {
        val clientDb = clientRepository!!.findById(id)
        if (clientDb.isPresent) {
            saveClientWithZipCode(client)
        }
    }

    override fun delete(id: Long) {
        clientRepository!!.deleteById(id)
    }

    private fun saveClientWithZipCode(client: Client) {
        val cep = client.address.cep
        val address = addressRepository!!.findById(cep).orElseGet {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            val newAddress = viaCepService!!.getAddressByZipCode(cep)

            newAddress.let {
                addressRepository.save(it)
            }

            newAddress
        }
        client.address = address
        clientRepository!!.save(client)
    }
}