package one.digitalinnovation.gof.service

import one.digitalinnovation.gof.model.Client

/**
 * Interface que define o padrão **Strategy** no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author falvojr
 */
interface ClientService {
    fun getAll(): Iterable<Client>
    fun getById(id: Long): Client
    fun insert(client: Client)
    fun update(id: Long, client: Client)
    fun delete(id: Long)
}