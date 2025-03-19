package com.scaler.productservice;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.repositories.projections.ProductTitleAndDesc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;


    @Test
    void contextLoads() {
    }

//    @Test
//    public void test() {
//        Optional<Product> productOptional = productRepository
//                .findByTitleAndCategory_name("iPhone", "phones");
//
//
//        System.out.println(productOptional.get().getTitle());
//    }
//
//    @Test
//    public void test2() {
//        List<Product> productOptional = productRepository
//                .getProductDate("phones");
//
//
//        System.out.println(productOptional.get(0).getTitle());
//    }
//
//    @Test
//    public void test3() {
//        Product productOptional = productRepository
//                .getProductData2(1L);
//
//
//        System.out.println(productOptional.getTitle());
//    }
//
//    @Test
//    public void test4() {
//        ProductTitleAndDesc product = productRepository
//                .getProductData3(1L);
//
//
//        System.out.println(product.getTitle() + ", " + product.getDescription());
//    }
//
//    @Test
//    @Transactional
//    public void testFetchTypes() {
//        Optional<Category> category = categoryRepository.findById(1L);
//        System.out.println(category.get().getName());
//        System.out.println(category.get().getProducts());
//    }
//
//    @Test
//    @Transactional
//    public void nplus1Problem() {
//        List<Category> categories = categoryRepository.findAll();
//        for(Category category: categories) {
//            for(Product product: category.getProducts()) {
//                System.out.println(product.getTitle());
//            }
//        }
//    }

}
