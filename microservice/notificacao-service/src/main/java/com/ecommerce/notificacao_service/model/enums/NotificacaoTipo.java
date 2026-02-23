package com.ecommerce.notificacao_service.model.enums;

public enum NotificacaoTipo {
    PEDIDO_CONFIRMACAO(1),
    PAGAMENTO_CONFIRMACAO(2);

    private int value;

    NotificacaoTipo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public NotificacaoTipo getNotificacao(int value) {
        for (NotificacaoTipo notificacao : NotificacaoTipo.values()) {
            if (notificacao.getValue() == value) {
                return notificacao;
            }
        }
        throw new IllegalArgumentException("Invalid TypeStatus code");
    }
}
