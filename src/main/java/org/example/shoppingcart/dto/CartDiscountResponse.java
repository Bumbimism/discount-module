package org.example.shoppingcart.dto;

import lombok.Data;

@Data
public class CartDiscountResponse {
    private double totalPrice;

    public CartDiscountResponse(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
