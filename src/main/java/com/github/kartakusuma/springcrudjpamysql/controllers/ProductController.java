package com.github.kartakusuma.springcrudjpamysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.kartakusuma.springcrudjpamysql.entities.Product;
import com.github.kartakusuma.springcrudjpamysql.services.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/store")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/store-list")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @PutMapping("/{id}/update")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        return service.updateProduct(product, id);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
    
}
