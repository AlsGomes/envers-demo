package br.com.agdev.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agdev.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
