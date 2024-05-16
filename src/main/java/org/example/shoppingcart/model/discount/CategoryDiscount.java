package org.example.shoppingcart.model.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDiscount extends Discount {
    private Double percentage;
    private List<String> category;


    @Override
    public double applyDiscount(double total, List<Item> items) {
        if(percentage == 0.0 || category.isEmpty()){
            return total;
        }
        double discount = 0L;
        for (Item item : items) {
            if (category.contains(item.getCategory())) {
                discount += (item.getPrice() * percentage / 100);
            }
        }
        return total - discount;
    }
    @Override
    public DiscountType getType() {
        return DiscountType.ONTOP;
    }
}