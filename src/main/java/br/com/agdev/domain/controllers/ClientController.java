package br.com.agdev.domain.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agdev.domain.model.Client;
import br.com.agdev.domain.repositories.client.ClientAudit;
import br.com.agdev.domain.repositories.client.ClientRepository;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		Client savedClient = clientRepository.save(client);
		return ResponseEntity.ok(savedClient);
	}

	@Transactional
	@PutMapping
	public ResponseEntity<Client> update(@RequestBody Client client) {
		Client existentClient = clientRepository.findById(client.getId()).get();
		BeanUtils.copyProperties(client, existentClient);
		Client savedClient = clientRepository.save(existentClient);
		return ResponseEntity.ok(savedClient);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<ClientAudit>> getAllAudits() {
		var clients = clientRepository.getClientAudits();
		return ResponseEntity.ok(clients);
	}
}
