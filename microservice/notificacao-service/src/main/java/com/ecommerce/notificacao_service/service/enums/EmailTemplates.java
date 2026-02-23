package com.ecommerce.notificacao_service.service.enums;

import lombok.Getter;

public enum EmailTemplates {

    PEDIDO_CONFIRMACAO_TEMPLATE("pedido-confirmacao.html", "Confirmação de Pedido"),
    PAGAMENTO_CONFIRMACAO_TEMPLATE("pagamento-confirmacao.html", "Pagamento confirmado com sucesso");

    @Getter
    private final String template;
    @Getter
    private final String assunto;


    EmailTemplates(String template, String assunto) {
        this.template = template;
        this.assunto = assunto;
    }
}

