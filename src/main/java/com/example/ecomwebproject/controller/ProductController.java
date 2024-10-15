package com.example.ecomwebproject.controller;


import com.example.ecomwebproject.Model.Product;
import com.example.ecomwebproject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service ;

    @RequestMapping("/products")
    public List<Product> getProducts()
    {
        Product p1 = new Product();
        List<Product> products = service.getAllProducts();
      // p1.addAttribute("products", products);
        return service.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return service.getProductById(id);
    }

    @PostMapping("/products/addProduct")
    public ResponseEntity<String> postProduct(@RequestBody Product product1)
    {
        Boolean X= ProductExists(product1);
        if(X) {
             service.addProduct(product1);
            return ResponseEntity.status(HttpStatus.OK).body("Product " + product1.getName() + " has been created successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already exists. Please use a different ID.");

    }

    public Boolean ProductExists(Product product)
    {
        if(service.findProductExists(product))
            return true;
        else
            return false;

    }





}
