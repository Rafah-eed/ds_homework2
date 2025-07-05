package com.example.payment.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String userId;
    private String courseId;
    private double amount;
}
