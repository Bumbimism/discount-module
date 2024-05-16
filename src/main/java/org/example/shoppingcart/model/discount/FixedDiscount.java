package org.example.shoppingcart.model.discount;

import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;
@Data
public class FixedDiscount extends Discount {
    private Double value;
    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (value == 0.0) {
            return total;
        }
        return total - value;
    }
    @Override
    public DiscountType getType() {
        return DiscountType.COUPON;
    }
}
