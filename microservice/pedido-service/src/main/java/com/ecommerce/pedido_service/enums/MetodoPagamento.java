package com.ecommerce.pedido_service.enums;

public enum MetodoPagamento {

    PIX(1),
    BOLETO(2),
    DEBITO(3),
    CREDITO(4);

    private final int value;

    MetodoPagamento(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static MetodoPagamento valueOf(int value) {
        for (MetodoPagamento pagamento : MetodoPagamento.values()) {
            if (pagamento.getValue() == value) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Invalid TypeStatus code");
    }
}

