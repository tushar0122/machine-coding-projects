package org.example.stockBroker.model;

import org.example.stockBroker.constants.OrderType;

import java.time.LocalDateTime;

public class Transaction {
    String id;
    String userId;
    String stockId;
    OrderType orderType;
    int quantity;
    int price;
    int totalPrice;
    LocalDateTime time;
}
