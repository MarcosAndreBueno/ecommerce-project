package com.ecommerce.cliente_service.repository;

import com.ecommerce.cliente_service.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
