package com.example.ecomwebproject.controller;


import com.example.ecomwebproject.Model.Product;
import com.example.ecomwebproject.Service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> getProducts() {
        Product p1 = new Product();
        List<Product> products = service.getAllProducts();
        // p1.addAttribute("products", products);
        return service.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/products/addProduct")
    public ResponseEntity<String> postProduct(@RequestBody Product product1) {
        Boolean X = ProductExists(product1);
        if (X) {
            service.addProduct(product1);
            return ResponseEntity.status(HttpStatus.OK).body("Product " + product1.getName() + " has been created successfully");
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product already exists. Please use a different ID.");

    }

    @PutMapping("/products/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product1) {
        Boolean X = ProductExists(product1);
        if (X) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product does not exist . Please use a different ID.");
        } else {
            service.updateProduct(product1);
            return ResponseEntity.status(HttpStatus.OK).body("Product has been updated successfully");
        }
    }


    public Boolean ProductExists(Product product) {
        return service.findProductExists(product);

    }

    @PostMapping("/products/{id}/uploadImage")
    public ResponseEntity<String> uploadImage(@PathVariable int id, @RequestParam("file") MultipartFile file)
    {
        try {
            service.uploadImage(id, file);
            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image.");
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/products/{id}/image")
    public void getImage(@PathVariable int id, HttpServletResponse response) throws IOException {
        byte[] image = service.getProductImage(id);

        response.setContentType("image/png");
        response.getOutputStream().write(image);
        response.getOutputStream().close();
    }

}
