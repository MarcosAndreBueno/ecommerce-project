package com.ecommerce.pedido_service.mensageria;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PedidoTopic {

    @Bean
    public NewTopic pedidoTopic() {
        return TopicBuilder
                .name("pedido-topic")
                .build();
    }
}
