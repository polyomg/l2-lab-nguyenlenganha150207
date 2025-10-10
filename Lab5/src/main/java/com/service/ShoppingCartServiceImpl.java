package com.service;

import com.model.DB;
import com.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = DB.items.get(id);
        if (item == null) return null;
        Item existing = map.get(id);
        if (existing == null) map.put(id, new Item(item.getId(), item.getName(), item.getPrice(), 1));
        else existing.setQty(existing.getQty() + 1);
        return item;
    }

    @Override
    public void remove(Integer id) { map.remove(id); }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) item.setQty(qty);
        return item;
    }

    @Override
    public void clear() { map.clear(); }

    @Override
    public Collection<Item> getItems() { return map.values(); }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
    }
}

