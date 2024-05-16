package org.example.shoppingcart.model.discount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

import static java.lang.Math.min;

@Data
public class PointDiscount extends Discount {
    @JsonProperty("Customer points")
    private int points;

    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (points == 0.0) {
            return total;
        }
        double discount = min(points, 0.2 * total);

        return total - discount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.ONTOP;
    }
}
