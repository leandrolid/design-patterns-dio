package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.service.ClientService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author falvojr
 */
@RestController
@RequestMapping("clientes")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<Iterable<Client>> buscarTodos() {
		return ResponseEntity.ok(clientService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.getById(id));
	}

	@PostMapping
	public ResponseEntity<Client> inserir(@RequestBody Client cliente) {
		clientService.insert(cliente);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> atualizar(@PathVariable Long id, @RequestBody Client client) {
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}
