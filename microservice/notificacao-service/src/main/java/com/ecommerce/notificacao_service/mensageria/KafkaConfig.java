package com.ecommerce.notificacao_service.mensageria;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

public class KafkaConfig {

    @Bean
    public DefaultErrorHandler errorHandler() {
        // 3 segundos entre tentativas, 3 tentativas
        FixedBackOff backOff = new FixedBackOff(
                3000L,
                3
        );

        return new DefaultErrorHandler(backOff);
    }
}
