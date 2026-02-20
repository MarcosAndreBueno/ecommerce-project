package com.ecommerce.pagamento_service.repository;

import com.ecommerce.pagamento_service.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
