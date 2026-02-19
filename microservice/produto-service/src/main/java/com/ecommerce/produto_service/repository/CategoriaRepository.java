package com.ecommerce.produto_service.repository;

import com.ecommerce.produto_service.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
