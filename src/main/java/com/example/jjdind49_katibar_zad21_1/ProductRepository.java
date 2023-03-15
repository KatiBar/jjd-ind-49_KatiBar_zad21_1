package com.example.jjdind49_katibar_zad21_1;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private final Set<Product> products = new HashSet<>();

    ProductRepository() {
        Product pasta = new Product("Makaron", 5.99, Category.FOOD);
        Product apples = new Product("Jabłka", 2.55, Category.FOOD);
        Product milk = new Product("Mleko", 1.99, Category.FOOD);
        Product vacuumCleaner = new Product("Odkurzacz", 299.50, Category.HOME);
        Product washingLiquid = new Product("Płyn do mycia podłóg", 10.2, Category.HOME);
        Product catFeed = new Product("Karma dla kota", 17.5, Category.OTHER);
        Product pampers = new Product("Pampersy", 59.85, Category.OTHER);

        products.add(pasta);
        products.add(apples);
        products.add(milk);
        products.add(vacuumCleaner);
        products.add(washingLiquid);
        products.add(catFeed);
        products.add(pampers);
    }

    Collection<Product> findProductByCategory(Category category) {
        Collection<Product> productFromCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productFromCategory.add(product);
            }
        }
        return productFromCategory;
    }

    Collection<Product> findAll() {
        return products;
    }

    void addProduct(Product product) {
        products.add(product);
    }
}
