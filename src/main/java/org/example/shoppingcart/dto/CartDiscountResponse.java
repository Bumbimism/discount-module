package org.example.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CartDiscountResponse {
    @JsonProperty("total_price")
    private double totalPrice;

    public CartDiscountResponse(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
