package org.example.shoppingcart.model.discount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;

import static java.lang.Math.floor;

@Data
public class SeasonalDiscount extends Discount {
    @JsonProperty("every_X_THB")
    private Double everyXTHB;

    @JsonProperty("discount_Y_THB")
    private Double discountYTHB;


    @Override
    public double applyDiscount(double total, List<Item> items) {
        if (everyXTHB == 0.0 && discountYTHB == 0.0) {
            return total;
        }
        return total - (floor(total / everyXTHB) * discountYTHB);
    }

    @Override
    public DiscountType getType() {
        return DiscountType.SEASONAL;
    }
}
