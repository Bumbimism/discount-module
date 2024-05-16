package org.example.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

@Data
public class CartDiscountRequest {
    @JsonProperty("items_in_cart")
    private List<Item> items;
    @JsonProperty("discounts")
    private List<Discount> discounts;
}
