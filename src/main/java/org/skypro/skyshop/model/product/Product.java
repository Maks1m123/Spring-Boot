package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {

    private final String name;
    private final UUID id;

    public Product(UUID id,String name) {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Название не верное!");
        }
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial(){
        return false;
    }
    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return name;
    }
    @JsonIgnore
    @Override
    public String getType() {
        return "PRODUCT";
    }


    @Override
    public UUID getId() {
        return id;
    }
}
