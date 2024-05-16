package org.example.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

@Data
public class CartDiscountRequest {
    @JsonProperty("Items in cart")
    private List<Item> items;
    @JsonProperty("Discount")
    private List<Discount> discounts;
}
