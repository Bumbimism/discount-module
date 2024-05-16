package org.example.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CartDiscountResponse {
    @JsonProperty("Total Price")
    private double totalPrice;

    public CartDiscountResponse(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
