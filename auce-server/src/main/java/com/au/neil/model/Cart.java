package com.au.neil.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "cart_item",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "cart_id") }
    )
    private List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
