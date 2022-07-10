package one.digitalinnovation.gof.controller

import one.digitalinnovation.gof.model.Client
import org.springframework.beans.factory.annotation.Autowired
import one.digitalinnovation.gof.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Esse [RestController] representa nossa **Facade**, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author falvojr
 */
@RestController
@RequestMapping("clients")
class ClientRestController {
    @Autowired
    private val clientService: ClientService? = null
    @GetMapping
    fun getAll(): ResponseEntity<Iterable<Client?>?> {
        return ResponseEntity.ok(
            clientService!!.getAll()
        )
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Client> {
        return ResponseEntity.ok(clientService!!.getById(id))
    }

    @PostMapping
    fun insert(@RequestBody client: Client): ResponseEntity<Client> {
        clientService!!.insert(client)
        return ResponseEntity.ok(client)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Client): ResponseEntity<Client> {
        clientService!!.update(id, client)
        return ResponseEntity.ok(client)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        clientService!!.delete(id)
        return ResponseEntity.ok().build()
    }
}