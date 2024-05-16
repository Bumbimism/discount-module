package org.example.shoppingcart.model.discount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

@Data
public class PercentageDiscount extends Discount {
    @JsonProperty("percentage")
    private Double percentage;

    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (percentage == 0.0) {
            return total;
        }
        return total - (total * percentage / 100.00);
    }

    @Override
    public DiscountType getType() {
        return DiscountType.COUPON;
    }
}
