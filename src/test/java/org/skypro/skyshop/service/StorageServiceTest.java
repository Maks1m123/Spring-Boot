package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class StorageServiceTest {

    private final StorageService  storageService = new StorageService();

    @Test
    void getAllProducts() {
        List<Product> products = List.of(
                new SimpleProduct(UUID.randomUUID(),"Томаты",120),
                new SimpleProduct(UUID.randomUUID(),"Кабель", 450),
                new SimpleProduct(UUID.randomUUID(),"Балон Газовый",1100)
        );
        Collection<Product> allProducts = storageService.getAllProducts();

        products.forEach(item -> {
            assertTrue(allProducts.contains(item));
        });
    }

    @Test
    void getAllArticles() {
        List<Article> articles = List.of(
                new Article(UUID.randomUUID(),"Магазин1","#1"),
                new Article(UUID.randomUUID(),"Магазин2","#2"),
                new Article(UUID.randomUUID(),"Магазин3","#3")
        );
        Collection<Article> allArticles = storageService.getAllArticles();

        assertEquals(articles.size(), allArticles.size());
    }
}