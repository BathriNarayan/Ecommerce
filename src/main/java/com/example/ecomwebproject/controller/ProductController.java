package com.example.ecomwebproject.controller;


import com.example.ecomwebproject.Model.Product;
import com.example.ecomwebproject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service ;
    @RequestMapping("/")
    public String home() {
        return "What the fuck is this da bunda ";
    }
    @RequestMapping("/products")
    public List<Product> getProducts()
    {
        Product p1 = new Product();
        List<Product> products = service.getAllProducts();
      // p1.addAttribute("products", products);
        return service.getAllProducts();
    }
}
