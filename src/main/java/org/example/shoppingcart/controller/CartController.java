package org.example.shoppingcart.controller;

import org.example.shoppingcart.dto.CartDiscountRequest;
import org.example.shoppingcart.dto.CartDiscountResponse;
import org.example.shoppingcart.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final DiscountService discountService;

    public CartController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/promotions")
    public ResponseEntity<CartDiscountResponse> calculateFinalPrice(@RequestBody CartDiscountRequest cartDiscountRequest) {
        return new ResponseEntity<>(discountService.calculateFinalPrice(cartDiscountRequest), HttpStatus.OK);
    }
}
