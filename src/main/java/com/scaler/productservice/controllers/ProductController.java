package com.scaler.productservice.controllers;

import com.scaler.productservice.commons.AuthenticationCommons;
import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.ErrorDto;
import com.scaler.productservice.dtos.UserDto;
import com.scaler.productservice.exceptions.InvalidTokenException;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.FakeStoreProductService;
import com.scaler.productservice.services.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private AuthenticationCommons authenticationCommons;


    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService,
                             AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(products,
                        HttpStatusCode.valueOf(200));

        return responseEntity;
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id,
                                     @Nullable @RequestHeader("Authorization") String token) throws ProductNotFoundException, InvalidTokenException {
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto == null) {
            throw new InvalidTokenException();
        }

        return productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        Product product = productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );


        ResponseEntity<Product> responseEntity =
                new ResponseEntity<>(product, HttpStatusCode.valueOf(201));

        return responseEntity;
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> handleNPEException() {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Something went wrong");
//
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
//                HttpStatusCode.valueOf(501));
//
//        return responseEntity;
//    }
//
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handlePNFException() {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Product Not found. Please try again");
//
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
//                HttpStatusCode.valueOf(404));
//
//        return responseEntity;
//    }
}

// 1xx: information based responses
// 2xx - when everything worked as it should: 200 -> success, 201 -> created
// 3xx - redirects
// 4xx - something wrong with the client: 404, 400
// 5xx - something wrong on server side: 500
