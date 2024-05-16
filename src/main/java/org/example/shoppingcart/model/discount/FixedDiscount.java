package org.example.shoppingcart.model.discount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

@Data
public class FixedDiscount extends Discount {
    @JsonProperty("Amount")
    private Double amount;

    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (amount == 0.0) {
            return total;
        }
        return total - amount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.COUPON;
    }
}
