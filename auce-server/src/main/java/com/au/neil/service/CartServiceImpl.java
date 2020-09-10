package com.au.neil.service;

import com.au.neil.model.Cart;
import com.au.neil.model.Item;
import com.au.neil.repository.CartRepository;
import com.au.neil.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Cart initCart() {
        return cartRepository.save(new Cart());
    }

    public Cart addItem(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).get();
        Item item = itemRepository.findById(itemId).get();
        cart.addItem(item);
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart.getItems() == null) {
            cart.setItems(Collections.emptyList());
        }
        return cart;
    }
}
