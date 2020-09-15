package com.au.neil.service;

import com.au.neil.model.Cart;
import com.au.neil.model.Item;

import java.util.List;

public interface CartService {

    public Cart initCart();

    public Cart addItem(Long cartId, Long itemId);

    public Cart removeItem(Long cartId, Long itemId);

    public Cart getCartById(Long cartId);

}
