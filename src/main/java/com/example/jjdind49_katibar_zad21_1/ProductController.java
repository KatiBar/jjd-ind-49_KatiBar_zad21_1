package com.example.jjdind49_katibar_zad21_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(required = false, name = "kategoria") Category category) {
        Collection<Product> products;
        if (category == null) {
            products = productRepository.findAll();
        } else {
            products = productRepository.findProductByCategory(category);
            model.addAttribute("category", category);
        }
        model.addAttribute("products", products);
        model.addAttribute("sum", ProductUtility.calculatePricesSum(products));
        return "list";
    }

    @GetMapping("/add")
    String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    String addProductFromForm(Product product) {
        if (product != null && !product.getName().isEmpty() && product.getPrice() > 0 && product.getCategory() != null ) {
            productRepository.addProduct(product);
            return "redirect:/list?kategoria=" + product.getCategory();
        } else {
            return "redirect:/wrongProduct";
        }
    }

    @GetMapping("/wrongProduct")
    String err() {
        return "wrongProduct";
    }
}
