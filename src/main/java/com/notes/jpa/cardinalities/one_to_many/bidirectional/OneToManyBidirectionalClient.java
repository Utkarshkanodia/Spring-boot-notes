package com.notes.jpa.cardinalities.one_to_many.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("client_one_to_many")
public class OneToManyBidirectionalClient {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public void saveCategory() {
        Category category = new Category();
        List<Product> products = new ArrayList<>();
        String[] productList = {"iphone 11", "iphone 12", "iphone 13", "iphone 14", "iphone 15"};
        category.setName("Apple mobiles");
        for (int i = 0; i < 5; i++) {
            Product product = new Product();
            product.setName(productList[i]);
            products.add(product);
            product.setCategory(category);
        }
        category.setProducts(products);
        categoryRepository.save(category);
    }

    public Category getCategory() {
        return categoryRepository.findById(1L).get();
    }

    public Product getProduct() {
        return productRepository.findById(1L).get();
    }


}
