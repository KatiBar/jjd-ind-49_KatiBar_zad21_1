package com.example.jjdind49_katibar_zad21_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

public class ProductUtility {
    static double calculatePricesSum(Collection<Product> collection) {
        double sum = 0;
        int precision = 2;
        for (Product product : collection) {
            sum += product.getPrice();
        }
        return new BigDecimal(sum)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
