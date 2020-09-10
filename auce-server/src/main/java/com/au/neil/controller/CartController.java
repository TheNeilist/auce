package com.au.neil.controller;

import com.au.neil.model.Cart;
import com.au.neil.model.Item;
import com.au.neil.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart initCart() {
        return cartService.initCart();
    }

    @PatchMapping("{cartId}/item/{itemId}")
    public Cart addItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        return cartService.addItem(cartId, itemId);
    }

    @GetMapping("{cartId}")
    public Cart getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

}
