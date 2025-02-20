package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("abc");
        product1.setDescription("some desc");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("abc 2");
        product2.setDescription("some desc 2");

        List<Product> dummyProducts = new ArrayList<>();
        dummyProducts.add(product1);
        dummyProducts.add(product2);

        when(productService.getAllProducts()).thenReturn(
                dummyProducts
        );

        ResponseEntity<List<Product>> responseEntity =
                productController.getAllProducts();

        List<Product> products = responseEntity.getBody();

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("abc", products.get(0).getTitle());
        Assertions.assertEquals("abc 2", products.get(1).getTitle());
    }
}
