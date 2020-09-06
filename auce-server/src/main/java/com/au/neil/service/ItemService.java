package com.au.neil.service;

import com.au.neil.model.Item;

import java.util.List;

public interface ItemService {

    public List<Item> getItems();

    public void init();
}
