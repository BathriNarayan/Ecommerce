package com.example.ecomwebproject.Service;
import java.util.*;

import com.example.ecomwebproject.Model.Product;
import com.example.ecomwebproject.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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

    public Product uploadImage(int productId, MultipartFile file) throws IOException {
        Product product = repo.findById((long) productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setImage(file.getBytes());
        return repo.save(product);
    }
    public Product updateProduct(Product product1) {
        return repo.save( product1);

    }

    public byte[] getProductImage(int productId) {
        Product product = repo.findById((long) productId).orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getImage();
    }

}
