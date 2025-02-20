package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;


class FakeStoreProductServiceTest {
    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private RedisTemplate redisTemplate = Mockito.mock(RedisTemplate.class);

    private ValueOperations valueOperations = Mockito.mock(ValueOperations.class);

    FakeStoreProductService fakeStoreProductService =
            new FakeStoreProductService(restTemplate, redisTemplate);

    @Test
    public void testGetProductByIdWhenDataInCache() throws ProductNotFoundException {
        Product dummyProduct = new Product();
        dummyProduct.setId(1L);
        dummyProduct.setTitle("abc");

        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("1"))
                .thenReturn(dummyProduct);

        Product product = fakeStoreProductService
                .getProductDetails(1L);

        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("abc", product.getTitle());

        verify(valueOperations, times(0))
                .set(any(), any());
    }

    @Test
    public void testGetProductByIdWhenDataNotInCache() throws ProductNotFoundException {
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("1"))
                .thenReturn(null);

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle("abc");
        fakeStoreProductDto.setPrice("20.25");

        ResponseEntity<FakeStoreProductDto> responseEntity =
                new ResponseEntity<>(fakeStoreProductDto,
                        HttpStatusCode.valueOf(200));

        when(restTemplate
                .getForEntity(
                        "https://fakestoreapi.com/products/1",
                        FakeStoreProductDto.class
                )).thenReturn(responseEntity);


        Product product = fakeStoreProductService
                .getProductDetails(1L);

        Assertions.assertEquals("abc", product.getTitle());

        verify(valueOperations, times(1))
                .set(any(), any());
    }

}