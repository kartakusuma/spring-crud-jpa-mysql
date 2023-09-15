package com.github.kartakusuma.springcrudjpamysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.kartakusuma.springcrudjpamysql.entities.Product;
import com.github.kartakusuma.springcrudjpamysql.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public Product updateProduct(Product product, int id) {
        Product oldProduct = repository.findById(id).orElse(null);
        oldProduct.setName(product.getName());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setPrice(product.getPrice());
        return repository.save(oldProduct);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product deleted: " + id;
    }

}
