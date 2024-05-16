package org.example.shoppingcart.service;

import org.example.shoppingcart.dto.CartDiscountRequest;
import org.example.shoppingcart.dto.CartDiscountResponse;
import org.example.shoppingcart.exception.DiscountTypeDuplicateException;
import org.example.shoppingcart.model.Discount;
import org.example.shoppingcart.model.Item;
import org.example.shoppingcart.model.discount.DiscountType;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;


@Service
public class DiscountService {

    public CartDiscountResponse calculateFinalPrice(CartDiscountRequest cartDiscountRequest) {

        List<Item> items = cartDiscountRequest.getItems();
        List<Discount> discounts = cartDiscountRequest.getDiscounts();

        double total = items.stream().mapToDouble(Item::getPrice).sum();

        List<String> existType = discounts.stream().map(d -> d.getType().toString()).toList();
        HashSet<String> uniqueType = new HashSet<>(existType);

        if (existType.size() != uniqueType.size()) {
            throw new DiscountTypeDuplicateException("Cannot apply same discount type.");
        }

        List<Discount> coupon = discounts.stream().filter(d -> d.getType() == DiscountType.COUPON).toList();
        List<Discount> onTop = discounts.stream().filter(d -> d.getType() == DiscountType.ONTOP).toList();
        List<Discount> seasonal = discounts.stream().filter(d -> d.getType() == DiscountType.SEASONAL).toList();


        if (!coupon.isEmpty()) {
            total = calculatePrice(total, items, coupon);
        }

        if (!onTop.isEmpty()) {
            total = calculatePrice(total, items, onTop);
        }

        if (!seasonal.isEmpty()) {
            total = calculatePrice(total, items, seasonal);
        }
        if (total < 0) {
            return new CartDiscountResponse(0.0);
        }

        return new CartDiscountResponse(total);
    }

    private double calculatePrice(double total, List<Item> items, List<Discount> discounts) {
        double Price = 0.0;
        for (Discount discount : discounts) {
            Price = discount.applyDiscount(total, items);
        }
        return Price;
    }
}