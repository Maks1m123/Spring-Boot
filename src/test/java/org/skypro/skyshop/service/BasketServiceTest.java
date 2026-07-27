package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    StorageService storageService;

    @Mock
    ProductBasket productBasket;

    @InjectMocks
    BasketService basketService;

    @Test
    void addProduct() {
        UUID nonExistentId = UUID.randomUUID();
        Mockito.when(storageService.getProductById(nonExistentId))
                .thenThrow(new NoSuchProductException("Продукт не найден"));

        assertThrows(NoSuchProductException.class, () -> {
            basketService.addProduct(nonExistentId);
        });
        verify(productBasket, never()).addProduct(any());

        UUID existentId = UUID.randomUUID();
        SimpleProduct product = new SimpleProduct(existentId, "Молоко", 80);

        Mockito.when(storageService.getProductById(existentId)).thenReturn(product);

        basketService.addProduct(existentId);
        verify(productBasket, times(1)).addProduct(existentId);
    }

    @Test
    void getUserBasket() {
        Mockito.when(productBasket.getBasket()).thenReturn(Collections.emptyMap());
        var emptyBasket = basketService.getUserBasket();
        assertNotNull(emptyBasket);
        assertTrue(emptyBasket.getItems().isEmpty());
    }
}