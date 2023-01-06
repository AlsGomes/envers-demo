package br.com.agdev.domain.repositories.client;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agdev.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientAuditsRepository {

}
