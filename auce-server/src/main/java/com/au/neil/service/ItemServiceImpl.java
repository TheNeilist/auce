package com.au.neil.service;

import com.au.neil.model.Item;
import com.au.neil.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void init() {
        itemRepository.deleteAll();
        itemRepository.save(new Item("Taco"));
        itemRepository.save(new Item("Burrito"));
        itemRepository.save(new Item("Enchilada"));
    }
}
