package org.example.shoppingcart.dto;

import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

@Data
public class CartDiscountRequest {
    private List<Item> items;
    private List<Discount> discounts;
}
