package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> storageProducts;
    private final Map<UUID, Article> storageArticles;

    public StorageService() {
        this.storageProducts = new HashMap<>();
        this.storageArticles = new HashMap<>();

        addTest();
    }

    public Collection<Product> getAllProducts() {
        return this.storageProducts.values();
    }
    public Collection<Article> getAllArticles() {
        return this.storageArticles.values();
    }
    public Collection<Searchable> getAllSearchables() {
        List<Searchable> searchables = new ArrayList<>();
        searchables.addAll(this.storageProducts.values());
        searchables.addAll(this.storageArticles.values());
        return searchables;
    }

    private void addTest(){
        UUID uuid1 = UUID.randomUUID();
        storageProducts.put(uuid1,new SimpleProduct(uuid1,"Томаты",120));
        UUID uuid2 = UUID.randomUUID();
        storageProducts.put(uuid2,new SimpleProduct(uuid2,"Кабель", 450));
        UUID uuid3 = UUID.randomUUID();
        storageProducts.put(uuid3,new SimpleProduct(uuid3,"Балон Газовый",1100));

        UUID uuid4 = UUID.randomUUID();
        storageArticles.put(uuid4,new Article(uuid4,"Магазин","#12345"));
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(storageProducts.get(id));
    }
}

