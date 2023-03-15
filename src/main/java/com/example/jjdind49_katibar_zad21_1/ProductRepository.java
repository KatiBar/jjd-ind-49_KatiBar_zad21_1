package com.example.jjdind49_katibar_zad21_1;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private final Set<Product> products = new HashSet<>();

    ProductRepository() {
        Product makaron = new Product("Makaron", 5.99, Category.FOOD);
        Product jablka = new Product("Jabłka", 2.55, Category.FOOD);
        Product mleko = new Product("Mleko", 1.99, Category.FOOD);
        Product odkurzacz = new Product("Odkurzacz", 299.50, Category.HOME);
        Product plyn = new Product("Płyn do mycia podłóg", 10.2, Category.HOME);
        Product karma = new Product("Karma dla kota", 17.5, Category.OTHER);
        Product pampersy = new Product("Pampersy", 59.85, Category.OTHER);

        products.add(makaron);
        products.add(jablka);
        products.add(mleko);
        products.add(odkurzacz);
        products.add(plyn);
        products.add(karma);
        products.add(pampersy);
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
