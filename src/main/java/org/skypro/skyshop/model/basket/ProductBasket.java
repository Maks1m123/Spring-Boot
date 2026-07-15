package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SessionScope
@Service
public class ProductBasket {

    private final Map<UUID,Integer> basket = new HashMap<>();

    public void addProduct(UUID id) {
        if (basket.containsKey(id)) {
            basket.put(id, basket.get(id) + 1);
        } else {
            basket.put(id, 1);
        }
    }
    public Map<UUID,Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }


}
