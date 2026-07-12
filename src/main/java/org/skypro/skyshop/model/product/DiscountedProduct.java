package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(UUID id, String name, int basePrice, int discountPercent) {
        super(id,name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Проверка базовой цены не прошла!");
        }
        if (discountPercent < 0 || discountPercent >100){
            throw new IllegalArgumentException("Проверка цены скидки не прошла!");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        int i = (basePrice * discountPercent) / 100;
        return basePrice - i;
    }
    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + " скидка(" + discountPercent + " %)";
    }
}
