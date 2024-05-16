package org.example.shoppingcart.model.discount;

import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

import static java.lang.Math.min;

@Data
public class PointDiscount extends Discount {
    private int value;

    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (value == 0.0) {
            return total;
        }
        double discount = min(value, 0.2 * total);

        return total - discount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.ONTOP;
    }
}
