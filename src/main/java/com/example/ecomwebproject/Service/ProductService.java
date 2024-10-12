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


}
