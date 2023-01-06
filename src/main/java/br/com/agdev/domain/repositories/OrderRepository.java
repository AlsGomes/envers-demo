package br.com.agdev.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agdev.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
