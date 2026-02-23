package com.ecommerce.pagamento_service.mensageria;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPagamentoTopic {

    @Bean
    public NewTopic pagamentoConfirmadoTopic() {
        return TopicBuilder
                .name("pagamento-confirmado-topic")
                .build();
    }
}
