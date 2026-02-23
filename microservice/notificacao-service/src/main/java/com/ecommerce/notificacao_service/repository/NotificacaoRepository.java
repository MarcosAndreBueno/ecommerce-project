package com.ecommerce.notificacao_service.repository;

import com.ecommerce.notificacao_service.model.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {
}
