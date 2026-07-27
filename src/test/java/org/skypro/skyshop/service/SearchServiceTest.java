package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    StorageService storageService;

    @InjectMocks
    SearchService searchService;

    @Test
    void testFound() {
        Mockito.when(storageService.getAllSearchables()).thenReturn(
                List.of(
                        new SimpleProduct(UUID.randomUUID(),"Томаты",120),
                        new SimpleProduct(UUID.randomUUID(),"Кабель", 450),
                        new SimpleProduct(UUID.randomUUID(),"Балон Газовый",1100))
        );
        Collection<SearchResult> tomatoes  = searchService.search("Томаты");

        assertFalse(tomatoes.isEmpty());
        assertEquals(1,tomatoes.size());
    }


}