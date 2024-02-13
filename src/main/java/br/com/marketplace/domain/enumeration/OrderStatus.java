package br.com.marketplace.domain.enumeration;

public enum OrderStatus {
    PROCESSING_PAYMENT(1),
    PACKING(2),
    SHIPPING(3),
    DELIVERED(4);

    OrderStatus(int statusNumber) {
    }
}
