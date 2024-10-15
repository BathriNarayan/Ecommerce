package com.example.ecomwebproject.Service;
import java.util.*;

import com.example.ecomwebproject.Model.Product;
import com.example.ecomwebproject.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo ;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }


    public Product getProductById(long id) {
        return repo.findById(id).get();
    }

    public Product addProduct(Product product1) {
        return repo.save( product1);
    }

    public Boolean findProductExists(Product product)
    {
        if(repo.findById(product.getId()).isPresent()) {
            return false;
        }
        else
            return true;
    }
}
